package com.wezacare.forms.app.components.formtypes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wezacare.forms.app.model.ui.FormField
import com.wezacare.forms.app.model.ui.FormMargin
import com.wezacare.forms.app.model.data.FormTheme
import com.wezacare.forms.app.model.data.QuestionModel
import com.wezacare.forms.app.model.data.toFormOption
import com.wezacare.forms.app.model.ui.ValidationRule
import com.wezacare.forms.app.tranformer.FormType
import com.wezacare.forms.app.tranformer.IFormTransformer
import com.wezacare.forms.core.Icons.MyIconPack
import com.wezacare.forms.core.Icons.myiconpack.Checkbox
import com.wezacare.forms.core.Icons.myiconpack.CheckboxBlank
import com.wezacare.forms.core.presentation.DEFAULT_FORM_COLOR
import com.wezacare.forms.core.presentation.FormErrorRed
import com.wezacare.forms.core.presentation.SubtitleGray

data class FormCheckBoxInput (
    override val id: String,
    override val pageId: String,
    override val label: String,
    val optionList: List<FormOption>,
    val subLabel: String? = null,
    val showPageTitle: Boolean = false,
    val color: Color = DEFAULT_FORM_COLOR,
    val pageTitle: String? = null,
    override val placeholder: String = "",
    override val required: Boolean = false,
    override val validators: List<ValidationRule> = emptyList(),
    val tint : Color? = null,
    override val margin: FormMargin = FormMargin(4.dp, 4.dp)
): FormField<String> {

    class Transformer(override val question: QuestionModel, override val theme: FormTheme? = null): IFormTransformer {
        override val type: FormType
            get() = FormType.CHECKBOX

        override fun transform(): FormField<Any> {
            return FormCheckBoxInput(
                id = question.id,
                pageId = question.pageId,
                label = question.label,
                placeholder = question.placeholder ?: "",
                subLabel = question.description,
                pageTitle = question.sectionBanner,
                showPageTitle = question.isFirst,
                required = question.required,
                optionList = question.options?.map { it.toFormOption() } ?: emptyList(),
                tint = theme?._primaryColor
            ) as FormField<Any>
        }
    }

    override fun validate(value: String?): String? {
        if(required && value.isNullOrEmpty()) {
            return "Field cannot be empty"
        }
        return null
    }

    @Composable
    override fun Render(
        values: Map<String, Any>,
        onValueChange: (String, String) -> Unit,
        errors: Map<String, String?>
    ) {
        val stringValue = values[id] as? String
        val listValue = stringValue?.split(",") ?: listOf()
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
                    optionTitle = item.label,
                    isSelected = item.value in listValue,
                    selectedTint = tint ?: Color.Blue.copy(0.6f),
                    onClick = {
                        val _checkItems = mutableListOf<String>()
                        listValue.forEach { _checkItems.add(it) }

                        if(item.value in listValue) {
                            _checkItems.remove(item.value)
                        } else {
                            _checkItems.add(item.value)
                        }
                        onValueChange(id, _checkItems.joinToString(separator = ","))
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