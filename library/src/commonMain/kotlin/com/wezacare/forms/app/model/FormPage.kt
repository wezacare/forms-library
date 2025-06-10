package com.wezacare.forms.app.model

data class FormPage(
    val id: String,
    val title: String,
    val description: String? = null,
    val completed: Boolean = false,
    val components: List<FormElement<Any>>
)