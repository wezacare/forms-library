package com.wezacare.forms.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.CheckBoxOutlineBlank
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wezacare.forms.app.model.FormField
import com.wezacare.forms.app.model.FormMargin
import com.wezacare.forms.app.model.ValidationRule
import com.wezacare.forms.core.Icons.MyIconPack
import com.wezacare.forms.core.Icons.myiconpack.Checkbox
import com.wezacare.forms.core.Icons.myiconpack.CheckboxBlank
import com.wezacare.forms.core.presentation.DEFAULT_FORM_COLOR
import com.wezacare.forms.core.presentation.FormBorderGray
import com.wezacare.forms.core.presentation.FormErrorRed
import com.wezacare.forms.core.presentation.SubtitleGray
import com.wezacare.forms.core.presentation.formVioletDark

data class FormCheckBoxInput (
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
    val tint : Color? = null,
    override val margin: FormMargin = FormMargin(4.dp, 4.dp)
): FormField<List<Int>> {

    override fun validate(value: List<Int>?): String? {
        if(required && value.isNullOrEmpty()) {
            return "Field cannot be empty"
        }
        return null
    }

    @Composable
    override fun Render(
        values: Map<String, Any>,
        onValueChange: (String, List<Int>) -> Unit,
        errors: Map<String, String?>
    ) {
        val value = values[id] as? List<Int> ?: listOf()
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
                lineHeight = 16.sp
            )
            if(!subLabel.isNullOrBlank()) {
                Text(
                    modifier = Modifier
                        .padding(vertical = 6.dp),
                    text = subLabel,
                    color = SubtitleGray,
                    lineHeight = 16.sp
                )
            }
            Spacer(modifier = Modifier.size(3.dp))
            optionList.forEachIndexed { index, item ->
                CheckBoxItem(
                    optionTitle = item,
                    isSelected = index in value,
                    selectedTint = tint ?: Color.Blue.copy(0.6f),
                    onClick = {
                        val _checkItems = mutableListOf<Int>()
                        value.forEach { _checkItems.add(it) }

                        if(index in value) {
                            _checkItems.remove(index)
                        } else {
                            _checkItems.add(index)
                        }
                        onValueChange(id, _checkItems)
                    },

                )
            }
        }
        Spacer(modifier = Modifier.size(margin.bottom))
    }

    @Composable
    private fun CheckBoxItem(
        optionTitle: String,
        isSelected: Boolean,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        selectedTint: Color = Color.Blue.copy(0.6f),
        defaultTint: Color = Color.Gray.copy(0.6f)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(end = 30.dp)
                .clickable { onClick() },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                modifier = Modifier
                    .size(26.dp)
                    .padding(vertical = 2.dp)
                    .padding(end = 8.dp),
                imageVector = if(isSelected) MyIconPack.Checkbox else
                    MyIconPack.CheckboxBlank,
                contentDescription = "Radio button",
                tint = if (isSelected) selectedTint else defaultTint
            )
            Text(
                text = optionTitle
            )
        }
    }
}