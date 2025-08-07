package com.wezacare.forms.app.model

import com.wezacare.forms.app.tranformer.FormType
import com.wezacare.forms.app.tranformer.IFormTransformer

interface FormField<T>: FormElement<T> {
    val pageId: String
    val label: String
    val placeholder: String?
    val required: Boolean
    val validators: List<ValidationRule>

    fun validate(value: T?): String?
}