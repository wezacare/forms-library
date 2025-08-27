package com.wezacare.forms.app.model.ui

data class FormPage(
    val id: String,
    val formId: String?,
    val order: Int,
    val page: Int,
    val components: List<FormElement<Any>>,
)