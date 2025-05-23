package com.wezacare.forms.components

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
import com.wezacare.forms.app.FormField
import com.wezacare.forms.app.FormState
import com.wezacare.forms.core.presentation.FormBorderGray
import com.wezacare.forms.core.presentation.FormErrorRed
import com.wezacare.forms.core.presentation.SubtitleGray


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
fun FormOptionInput(
    title: String,
    optionList: List<String>,
    onOptionClicked: (index: Int) -> Unit,
    modifier: Modifier = Modifier,
    subTitle: String? = null,
    selectedOption: Int = -1,
    activeTint: Color = Color.Blue.copy(0.5f),
    inactiveTint: Color = Color.Gray.copy(0.6f),
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
        if(!subTitle.isNullOrBlank()) {
            Text(
                modifier = Modifier.padding(vertical = 2.dp),
                text = subTitle,
                color = SubtitleGray,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.size(3.dp))
        optionList.forEachIndexed { index, item ->
            OptionItem(
                optionTitle = item,
                isSelected = index == selectedOption,
                selectedTint = activeTint,
                defaultTint = inactiveTint,
                onClick = {
                    onOptionClicked(index)
                },
            )
        }

    }
}

@Composable
fun OptionInputComposable(
    field: FormField.RadioOption,
    formState: FormState
) {
    val value = formState.getValue(field.key) as? Int ?: -1

    FormOptionInput(
        title = field.label,
        subTitle = "",
        optionList = field.options,
        selectedOption = value,
        error = "",
        mandatoryField = field.required,
        onOptionClicked = { formState.setValue(field.key, it) }
    )
}