package com.wezacare.forms.app.model.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp

data class FormMargin(
    val top: Dp,
    val bottom: Dp
)

interface FormElement<T> {
    val id: String
    val margin: FormMargin

    @Composable
    fun Render(
        values: Map<String, Any>,
        onValueChange: (String, T) -> Unit,
        errors: Map<String, String?>
    )
}