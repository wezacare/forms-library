package com.wezacare.forms.components

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
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.wezacare.forms.app.FormField
import com.wezacare.forms.app.FormState
import com.wezacare.forms.core.presentation.FormBorderGray
import com.wezacare.forms.core.presentation.FormErrorRed
import com.wezacare.forms.core.presentation.bottomBorder

@Composable
fun FormTextInput(
    title: String,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isInputValid: Boolean = true,
    mandatoryField: Boolean = false,
    error: String? = null,
) {
    Column (
        modifier = modifier
            .background(Color.White, MaterialTheme.shapes.large)
            .clip(MaterialTheme.shapes.large)
            .border(1.dp,
                if(isInputValid) FormBorderGray else FormErrorRed,
                MaterialTheme.shapes.large
            )
            .padding(vertical = 12.dp, horizontal = 16.dp)
            .fillMaxWidth()
    ) {
        if(!error.isNullOrBlank() && !isInputValid) {
            Text(
                text = error,
                color = FormErrorRed,
                style = MaterialTheme.typography.labelSmall,
                fontStyle = FontStyle.Italic
            )
        }
        Text(
            text = buildAnnotatedString {
                append(title)
                if(mandatoryField) {
                    withStyle(style = SpanStyle(color = FormErrorRed)) {
                        append(" * ")
                    }
                }
            },
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.size(3.dp))

        BasicTextField(
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 6.dp)
                .bottomBorder(
                    1.dp,
                    if(isInputValid) FormBorderGray else FormErrorRed
                ),
            value = value,
            onValueChange = onValueChange,
            cursorBrush = SolidColor(Color.DarkGray),
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier.padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    if(value.isBlank()) {
                        Text(
                            text = placeholder ?: "",
                            color = FormBorderGray
                        )
                    } else {
                        innerTextField()
                    }
                }
            }
        )
    }
}


@Composable
fun TextInputComposable(
    field: FormField.Text,
    formState: FormState
) {
    val value =  formState.getValue(field.key) as? String ?: ""

    FormTextInput(
        title = field.label,
        placeholder = "Your answer",
        value = value,
        onValueChange = { formState.setValue(field.key, it) },
        error = "",
        mandatoryField = field.required
    )
}
