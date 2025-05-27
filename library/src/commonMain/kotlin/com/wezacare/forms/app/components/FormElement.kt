package com.wezacare.forms.app.components

import androidx.compose.runtime.Composable

sealed interface FormElement<T> {
    val id: String

    @Composable
    fun Render(
        formState: MutableMap<String, T>,
        errorState: MutableMap<String, String?>
    )
}