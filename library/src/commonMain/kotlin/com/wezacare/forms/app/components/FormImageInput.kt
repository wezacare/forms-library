package com.wezacare.forms.app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddPhotoAlternate
import androidx.compose.material.icons.outlined.AddPhotoAlternate
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wezacare.forms.app.model.FormField
import com.wezacare.forms.app.model.ValidationRule
import com.wezacare.forms.core.Icons.myiconpack.AddPhotoAlternate
import com.wezacare.forms.core.PermissionCallback
import com.wezacare.forms.core.PermissionManager
import com.wezacare.forms.core.createPermissionManager
import com.wezacare.forms.core.models.PermissionStatus
import com.wezacare.forms.core.models.PermissionType
import com.wezacare.forms.core.presentation.FormBorderGray
import com.wezacare.forms.core.presentation.FormErrorRed
import com.wezacare.forms.core.rememberCameraManager
import com.wezacare.forms.core.rememberGalleryManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

data class FormImageInput(
    override val id: String,
    override val label: String,
    override val placeholder: String? = "",
    override val required: Boolean = false,
    override val validators: List<ValidationRule> = emptyList()
): FormField<ImageBitmap?> {
    override fun validate(value: ImageBitmap?): String? {
        if (required && value == null) {
            return "Field is required"
        }
//        return validators.firstNotNullOfOrNull { it(value) }
        return null
    }

    @Composable
    override fun Render(
        values: Map<String, Any>,
        onValueChange: (String, ImageBitmap?) -> Unit,
        errors: Map<String, String?>
    ) {
        var value = values[id] as? ImageBitmap?
        val error = errors[id]

//        var imageBitmap by remember { mutableStateOf<ImageBitmap?>(null) }
        val coroutineScope = rememberCoroutineScope()
        var launchGallery by remember { mutableStateOf(value = false) }
        var launchSetting by remember { mutableStateOf(value = false) }

        var permissionRationalDialog by remember { mutableStateOf(value = false) }
        val permissionManager: PermissionManager = createPermissionManager(
            object: PermissionCallback {
                override fun onPermissionStatus(
                    permissionType: PermissionType,
                    status: PermissionStatus
                ) {
                    when(status) {
                        PermissionStatus.GRANTED -> {
                            when (permissionType) {
                                PermissionType.GALLERY -> launchGallery = true
                                PermissionType.CAMERA -> launchGallery = true
                            }
                        }

                        else -> {
                            permissionRationalDialog = true
                        }
                    }
                }
            }
        )

        val galleryManager = rememberGalleryManager { sharedImage ->
            coroutineScope.launch {
                val bitmap = withContext(Dispatchers.Default) {
                    sharedImage?.toImageBitmap()
                }
//                imageBitmap = bitmap
                value = bitmap
                onValueChange(id, bitmap)
            }
        }

        if (launchGallery) {
            if (permissionManager.isPermissionGranted(PermissionType.GALLERY)) {
                galleryManager.launch()
            } else {
                permissionManager.askPermission(PermissionType.GALLERY)
            }
            launchGallery = false
        }

        if (launchSetting) {
            permissionManager.launchSettings()
            launchSetting = false
        }

        if (permissionRationalDialog) {
            AlertMessageDialog(
                title = "Permission Required",
                message = "To add a Image file, please grant this permission. You can manage permissions in your device settings.",
                positiveButtonText = "Settings",
                negativeButtonText = "Cancel",
                onPositiveClick = {
                    permissionRationalDialog = false
                    launchSetting = true

                },
                onNegativeClick = {
                    permissionRationalDialog = false
                }
            )
        }

        Column(
            modifier = Modifier
                .background(Color.White, MaterialTheme.shapes.small)
                .clip(MaterialTheme.shapes.small)
                .border(1.dp,
                    if(error.isNullOrBlank()) FormBorderGray else FormErrorRed,
                    MaterialTheme.shapes.small
                )
                .padding(vertical = 10.dp, horizontal = 12.dp)
                .fillMaxWidth()
        ) {


            if(!error.isNullOrBlank()) {
                Text(
                    text = error,
                    color = FormErrorRed,
                    style = MaterialTheme.typography.labelSmall,
                    fontStyle = FontStyle.Italic
                )
            }
            Text(
                text = buildAnnotatedString {
                    append(label)
                    if(required) {
                        withStyle(style = SpanStyle(color = FormErrorRed)) {
                            append(" * ")
                        }
                    }
                },
                fontWeight = FontWeight.Normal
            )

            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = placeholder ?: "",
                color = FormBorderGray,
                fontSize = 13.sp
            )

            if(value == null) {
                Row(
                    modifier = Modifier
                        .background(Color.White, MaterialTheme.shapes.small)
                        .border(
                            1.05.dp,
                            if (error.isNullOrBlank()) FormBorderGray.copy(alpha = 0.5f) else FormErrorRed,
                            MaterialTheme.shapes.small
                        )
                        .clip(MaterialTheme.shapes.small)
                        .clickable {
                            galleryManager.launch()
                        }
                        .padding(vertical = 2.dp, horizontal = 12.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .size(26.dp)
                            .padding(vertical = 2.dp)
                            .padding(end = 8.dp),
                        imageVector = Icons.Outlined.AddPhotoAlternate,
                        contentDescription = "Image Input",
                        tint = Color.DarkGray
                    )
                    Text(
                        text = "Choose Image",
                        color = Color.DarkGray,
                        fontSize = 13.sp
                    )
                }
            } else {
                Row(
                    modifier = Modifier
                        .background(Color.White, MaterialTheme.shapes.small)
                        .clickable {
                            galleryManager.launch()
                        }
                        .height(200.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(MaterialTheme.shapes.small),
                        bitmap = value!!,
                        contentScale = ContentScale.Crop,
                        contentDescription = ""
                    )
                }

            }

        }
    }
    
}
