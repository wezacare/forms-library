package com.wezacare.forms.app.model.ui

import com.wezacare.forms.app.model.data.FormTheme

enum class NavigationMode {
    HORIZONTAL, VERTICAL
}

enum class ViewMode {
    EDIT, READONLY
}

data class MultiPageForm(
    val pages: List<FormPage>,
    val formTitle: String,
    val formDescription: String,
    val navigationMode: NavigationMode = NavigationMode.HORIZONTAL,
    val viewModel: ViewMode = ViewMode.EDIT,
    val formTheme: FormTheme? = null
)
