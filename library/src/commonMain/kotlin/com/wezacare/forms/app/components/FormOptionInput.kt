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
import androidx.compose.material.icons.filled.RadioButtonChecked
import androidx.compose.material.icons.filled.RadioButtonUnchecked
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
import com.wezacare.forms.app.model.ValidationRule
import com.wezacare.forms.core.presentation.FormBorderGray
import com.wezacare.forms.core.presentation.FormErrorRed
import com.wezacare.forms.core.presentation.SubtitleGray

data class FormOptionInput(
    override val id: String,
    override val label: String,
    val optionList: List<String>,
    val onValueChange: (Int) -> Unit,
    override val placeholder: String = "",
    val subLabel: String? = null,
    override val required: Boolean = false,
    override val value: Int = -1,
    override val error: String? = null,
    override val validators: List<ValidationRule> = emptyList(),
): FormField<Int> {
    override fun validate(value: Int): String? {
        if (required && value == -1) {
            return "Field cannot be empty"
        }
        return null
    }

    @Composable
    private fun OptionItem(
        optionTitle: String,
        isSelected: Boolean,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        selectedTint: Color = Color.Gray.copy(0.6f),
        defaultTint: Color = Color.Gray.copy(0.6f),
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
                imageVector = if(isSelected) Icons.Default.RadioButtonChecked else
                    Icons.Default.RadioButtonUnchecked,
                contentDescription = "Radio button",
                tint = if (isSelected) selectedTint else defaultTint
            )
            Text(
                text = optionTitle
            )
        }
    }

    @Composable
    override fun Render(
        formState: MutableMap<String, Int>,
        errorState: MutableMap<String, String?>
    ) {
        Column (
            modifier = Modifier
                .background(Color.White, MaterialTheme.shapes.large)
                .clip(MaterialTheme.shapes.large)
                .border(1.dp,
                    if(!error.isNullOrBlank()) FormBorderGray else FormErrorRed,
                    MaterialTheme.shapes.large
                )
                .padding(vertical = 12.dp, horizontal = 16.dp)
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
                fontWeight = FontWeight.SemiBold
            )
            if(!subLabel.isNullOrBlank()) {
                Text(
                    modifier = Modifier.padding(vertical = 2.dp),
                    text = subLabel,
                    color = SubtitleGray,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.size(3.dp))
            optionList.forEachIndexed { index, item ->
                OptionItem(
                    optionTitle = item,
                    isSelected = index == value,
                    onClick = {
                        onValueChange(index)
                    },
                )
            }

        }
    }

}