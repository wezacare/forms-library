package com.wezacare.forms.app.model.ui

interface FormField<T>: FormElement<T> {
    val pageId: String
    val label: String
    val placeholder: String?
    val required: Boolean
    val validators: List<ValidationRule>

    fun validate(value: T?): String?
}