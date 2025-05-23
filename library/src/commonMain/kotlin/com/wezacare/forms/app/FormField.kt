package com.wezacare.forms.app

sealed class FormField(key: String) {
    data class Text(
        val label: String,
        val key: String,
        val required: Boolean = false,
    ) : FormField(key)

    data class Checkbox(
        val label: String,
        val key: String,
        val options: List<String>,
        val required: Boolean = false
    ) : FormField(key)

    data class RadioOption(
        val label: String,
        val key: String,
        val options: List<String>,
        val required: Boolean = false
    ) : FormField(key)

    data class Banner(
        val key: String,
        val title: String,
        val description: String,
    ) : FormField(key)
}