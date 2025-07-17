package com.wezacare.forms.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Link
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wezacare.forms.app.model.FormDecorator
import com.wezacare.forms.app.model.FormMargin
import com.wezacare.forms.core.presentation.DEFAULT_FORM_COLOR

data class FormLinkedDoc (
    override val id: String,
    val title: String,
    val link: String,
    val tint: Color? = DEFAULT_FORM_COLOR,
    override val margin: FormMargin = FormMargin(4.dp, 4.dp)
): FormDecorator {

    @Composable
    override fun Render(
        values: Map<String, Any>,
        onValueChange: (String, String) -> Unit,
        errors: Map<String, String?>
    ) {

        Spacer(modifier = Modifier.size(margin.top))
        Row(
            modifier = Modifier
                .background(
                    color = tint ?: Color.Blue.copy(alpha = 0.7f),
                    shape = MaterialTheme.shapes.extraLarge
                )
                .padding(horizontal = 16.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(16.dp),
                imageVector = Icons.Default.Link,
                contentDescription = "",
                tint = Color.White
            )
            Text(
                text = title,
                color = Color.White,
                fontSize = 12.sp
            )
        }
        Spacer(modifier = Modifier.size(margin.bottom))
    }
}