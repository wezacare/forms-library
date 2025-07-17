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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wezacare.forms.app.model.FormField
import com.wezacare.forms.app.model.FormMargin
import com.wezacare.forms.app.model.ValidationRule
import com.wezacare.forms.core.presentation.DEFAULT_FORM_COLOR
import com.wezacare.forms.core.presentation.FormBorderGray
import com.wezacare.forms.core.presentation.FormErrorRed
import com.wezacare.forms.core.presentation.SubtitleGray
import com.wezacare.forms.core.presentation.bottomBorder
import com.wezacare.forms.core.presentation.formVioletDark


data class FormTextInput(
    override val id: String,
    override val label: String,
    val description: String? = null,
    val showPageTitle: Boolean = false,
    val color: Color = DEFAULT_FORM_COLOR,
    val pageTitle: String? = null,
    override val placeholder: String? = "",
    override val required: Boolean = false,
    override val validators: List<ValidationRule> = emptyList(),
    override val margin: FormMargin = FormMargin(4.dp, 4.dp)

    ): FormField<String> {
    override fun validate(value: String?): String? {
        if (required && value.isNullOrBlank()) {
            return "Field is required"
        }
        return validators.firstNotNullOfOrNull {
            if (value != null) {
                it(value)
            } else null
        }
    }

    @Composable
    override fun Render(
        values: Map<String, Any>,
        onValueChange: (String, String) -> Unit,
        errors: Map<String, String?>
    ) {

        val value = values[id] as? String
        val error = errors[id]

        Spacer(modifier = Modifier.size(margin.top))
        FormItemContainer (
            isValid = error.isNullOrBlank(),
            color = color,
            showPageTitle = showPageTitle,
            page = pageTitle
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
            Spacer(modifier = Modifier.size(4.dp))

            if(!description.isNullOrBlank()) {
                Text(
                    modifier = Modifier.padding(vertical = 4.dp),
                    text = description,
                    fontSize = 13.sp,
                    color = SubtitleGray,
                    lineHeight = 16.sp
                )
                Spacer(modifier = Modifier.size(4.dp))
            }

            BasicTextField(
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .border(
                        0.6.dp,
                        if(error.isNullOrBlank()) FormBorderGray else FormErrorRed,
                        MaterialTheme.shapes.extraSmall
                    )
                    .background(Color.LightGray.copy(alpha = 0.1f), MaterialTheme.shapes.extraSmall),
                value = value ?: "",
                onValueChange = {
                    onValueChange(id, it)
                },
                textStyle = TextStyle(
                    fontSize = 13.sp
                ),
                cursorBrush = SolidColor(Color.DarkGray),
                decorationBox = { innerTextField ->
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 12.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if(value.isNullOrBlank()) {
                            Text(
                                text = placeholder ?: "",
                                color = FormBorderGray,
                                fontSize = 13.sp
                            )
                        } else {
                            innerTextField()
                        }
                    }
                }
            )
        }
        Spacer(modifier = Modifier.size(margin.bottom))
    }
}