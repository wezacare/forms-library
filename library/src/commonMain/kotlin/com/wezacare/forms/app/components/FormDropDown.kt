package com.wezacare.forms.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.SpanStyle
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
import com.wezacare.forms.core.presentation.formVioletDark

data class FormDropDown(
    override val id: String,
    override val label: String,
    val optionList: List<String>,
    val subLabel: String? = null,
    val showPageTitle: Boolean = false,
    val color: Color = DEFAULT_FORM_COLOR,
    val pageTitle: String? = null,
    override val placeholder: String = "",
    override val required: Boolean = false,
    override val validators: List<ValidationRule> = emptyList(),
    override val margin: FormMargin = FormMargin(4.dp, 4.dp)
): FormField<String> {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Render(
        values: Map<String, Any>,
        onValueChange: (String, String) -> Unit,
        errors: Map<String, String?>
    ) {
        val value = values[id] as? String
        val error = errors[id]

        var expanded by remember { mutableStateOf(false) }
        val focusRequester = remember { FocusRequester() }
        val focusManager = LocalFocusManager.current

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

            if(!subLabel.isNullOrBlank()) {
                Text(
                    modifier = Modifier.padding(vertical = 4.dp),
                    text = subLabel,
                    fontSize = 13.sp,
                    color = SubtitleGray,
                    lineHeight = 16.sp
                )
                Spacer(modifier = Modifier.size(4.dp))
            }
            
            ExposedDropdownMenuBox(
                modifier = Modifier,
                expanded = expanded,
                onExpandedChange = { expanded = it },
            ) {
                Row(
                    modifier = Modifier
                        .border(
                            0.4.dp,
                            FormBorderGray,
                            MaterialTheme.shapes.extraSmall
                        )
                        .background(Color.White, MaterialTheme.shapes.extraSmall)
                        .clickable {
                            expanded = true
                            focusRequester.requestFocus()
                        }
                        .padding(vertical = 6.dp, horizontal = 10.dp)
                        .focusRequester(focusRequester)
                        .focusTarget()
                        .menuAnchor()
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier,
                        maxLines = 1,
                        text = value ?: placeholder
                    )
                    Icon(
                        imageVector = if(expanded) Icons.Default.KeyboardArrowUp
                            else Icons.Default.KeyboardArrowDown,
                        contentDescription = ""
                    )
                }


                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {
                        expanded = false
                        focusManager.clearFocus()
                    }
                )
                {
                    optionList.forEach { option ->
                        DropdownMenuItem(
                            text = { Text(option, style = MaterialTheme.typography.bodyMedium) },
                            onClick = {
                                onValueChange(id, option)
                                expanded = false
                                focusManager.clearFocus()
                            }
                        )
                    }
                }
            }

        }
        Spacer(modifier = Modifier.size(margin.bottom))
    }

    override fun validate(value: String?): String? {
        if(required && value.isNullOrBlank()) {
            return "Field cannot be empty"
        }
        return null
    }

}
