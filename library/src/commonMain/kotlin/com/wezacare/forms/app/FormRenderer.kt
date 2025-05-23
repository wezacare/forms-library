package com.wezacare.forms.app

import androidx.compose.runtime.Composable
import com.wezacare.forms.components.BannerComposable
import com.wezacare.forms.components.CheckBoxComposable
import com.wezacare.forms.components.OptionInputComposable
import com.wezacare.forms.components.TextInputComposable

@Composable
fun FormFieldRenderer(
    field: FormField,
    formState: FormState,
) {
    when (field) {
        is FormField.Text -> TextInputComposable(field, formState)
        is FormField.Checkbox -> CheckBoxComposable(field, formState)
        is FormField.RadioOption -> OptionInputComposable(field, formState)
        is FormField.Banner -> BannerComposable(field)
        else -> {}
    }
}