package com.wezacare.forms.app.components

import com.wezacare.forms.app.model.ValidationRule

sealed interface FormField<T>: FormElement<T> {
    val label: String
    val placeholder: String
    val required: Boolean
    val value: T
    val error: String?
    val validators: List<ValidationRule>

    fun validate(value: T): String?

}