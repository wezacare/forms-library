package com.wezacare.forms.app.model

data class FormPage(
    val page: Int,
    val completed: Boolean = false,
    val components: List<FormElement<Any>>
)