package com.wezacare.forms.app.model

import androidx.compose.runtime.Composable

interface FormElement<T> {
    val id: String

    @Composable
    fun Render(
        values: Map<String, Any>,
        onValueChange: (String, T) -> Unit,
        errors: Map<String, String?>
    )
}