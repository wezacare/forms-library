package com.wezacare.forms.app.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

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