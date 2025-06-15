package com.wezacare.forms.app.model

interface FormField<T>: FormElement<T> {
    val label: String
    val placeholder: String?
    val required: Boolean
    val validators: List<ValidationRule>

    fun validate(value: T): String?
}