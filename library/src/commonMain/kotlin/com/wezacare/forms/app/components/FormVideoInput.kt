package com.wezacare.forms.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddPhotoAlternate
import androidx.compose.material.icons.outlined.Videocam
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wezacare.forms.app.model.FormField
import com.wezacare.forms.app.model.ValidationRule
import com.wezacare.forms.core.presentation.FormBorderGray
import com.wezacare.forms.core.presentation.FormErrorRed

data class FormVideoInput(
    override val id: String,
    override val label: String,
    override val placeholder: String? = "",
    override val required: Boolean = false,
    override val validators: List<ValidationRule> = emptyList()
): FormField<String> {
    override fun validate(value: String): String? {
        if (required && value.isBlank()) {
            return "Field is required"
        }
        return validators.firstNotNullOfOrNull { it(value) }
    }

    @Composable
    override fun Render(
        values: Map<String, Any>,
        onValueChange: (String, String) -> Unit,
        errors: Map<String, String?>
    ) {
        val value = values[id] as? String
        val error = errors[id]

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

            if(value.isNullOrBlank()) {
                Text(
                    modifier = Modifier.padding(vertical = 8.dp),
                    text = placeholder ?: "",
                    color = FormBorderGray,
                    fontSize = 13.sp
                )
            }
            Row(
                modifier = Modifier
                    .background(Color.White, MaterialTheme.shapes.small)
                    .border(1.05.dp,
                        if(error.isNullOrBlank()) FormBorderGray.copy(alpha = 0.5f) else FormErrorRed,
                        MaterialTheme.shapes.small
                    )
                    .clip(MaterialTheme.shapes.small)
                    .clickable {  }
                    .padding(vertical = 2.dp, horizontal = 12.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    modifier = Modifier
                        .size(28.dp)
                        .padding(vertical = 2.dp)
                        .padding(end = 8.dp),
                    imageVector = Icons.Outlined.Videocam,
                    contentDescription = "Video Input",
                    tint = Color.DarkGray
                )
                Text(
                    text = "Choose Video",
                    color = Color.DarkGray,
                    fontSize = 13.sp
                )
            }

        }

    }

}
