package com.wezacare.forms.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
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
import com.wezacare.forms.core.presentation.bottomBorder


data class FormTextInput(
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

        Column (
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
            Spacer(modifier = Modifier.size(3.dp))

            BasicTextField(
                modifier = Modifier.fillMaxWidth()
                    .padding(bottom = 4.dp)
                    .bottomBorder(
                        0.8.dp,
                        if(error.isNullOrBlank()) FormBorderGray else FormErrorRed
                    ),
                value = value ?: "",
                onValueChange = {
                    onValueChange(id, it)
                },
                textStyle = TextStyle(
                    fontSize = 12.sp
                ),
                cursorBrush = SolidColor(Color.DarkGray),
                decorationBox = { innerTextField ->
                    Row(
                        modifier = Modifier.padding(top = 8.dp, bottom = 5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if(value.isNullOrBlank()) {
                            Text(
                                text = placeholder ?: "",
                                color = FormBorderGray,
                                fontSize = 12.sp
                            )
                        } else {
                            innerTextField()
                        }
                    }
                }
            )
        }
    }
}