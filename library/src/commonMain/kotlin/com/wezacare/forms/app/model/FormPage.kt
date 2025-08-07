package com.wezacare.forms.app.model

data class FormPage(
    val id: String,
    val title: String,
    val formId: String,
    val order: Int,
    val page: Int,
    val formTheme: FormTheme,
    val components: List<FormElement<Any>>,
    val completed: Boolean = false
)