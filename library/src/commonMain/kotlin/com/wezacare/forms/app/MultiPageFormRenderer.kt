package com.wezacare.forms.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import com.wezacare.forms.app.pagers.HorizontalFormPager
import com.wezacare.forms.app.pagers.VerticalFormPager
import com.wezacare.forms.app.model.MultiPageForm
import com.wezacare.forms.app.model.NavigationMode

@Composable
fun MultiPageFormRenderer(
    form: MultiPageForm,
    onSubmit: (Map<String, Any>) -> Unit,
    onBackClick: () -> Unit,
) {

    val values: MutableMap<String, Any> = remember { mutableStateMapOf() }
    val errors: MutableMap<String, String?> = remember { mutableStateMapOf() }

    when (form.navigationMode) {
        NavigationMode.HORIZONTAL -> HorizontalFormPager(form, { onSubmit(values) }, onBackClick, values, errors)
        NavigationMode.VERTICAL -> VerticalFormPager(form, { onSubmit(values) }, values, errors)
    }

}