package com.wezacare.forms.app.model

enum class NavigationMode {
    HORIZONTAL, VERTICAL
}

data class MultiPageForm(
    val pages: List<FormPage>,
    val formTitle: String,
    val formDescription: String,
    val navigationMode: NavigationMode = NavigationMode.HORIZONTAL,
    val formTheme: FormTheme? = null
)
