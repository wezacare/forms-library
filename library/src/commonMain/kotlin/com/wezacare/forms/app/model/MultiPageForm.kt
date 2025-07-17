package com.wezacare.forms.app.model

enum class NavigationMode {
    HORIZONTAL, VERTICAL
}

data class MultiPageForm(
    val pages: List<FormPage>,
    val navigationMode: NavigationMode = NavigationMode.HORIZONTAL
)
