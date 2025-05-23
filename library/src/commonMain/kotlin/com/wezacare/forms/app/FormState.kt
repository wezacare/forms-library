package com.wezacare.forms.app

import androidx.compose.runtime.mutableStateMapOf

class FormState(fields: List<FormField>) {
    private val fieldValues = mutableStateMapOf<String, Any?>()

    init {
//        fields.forEach { field: FormField -> fieldValues[field.key] = null }
    }

    fun getValue(key: String): Any? = fieldValues[key]
    fun setValue(key: String, value: Any?) {
        fieldValues[key] = value
    }

    fun getAllValues(): Map<String, Any?> = fieldValues
}

fun FormState.validate(fields: List<FormField>): Boolean {
    return fields.all { field ->
        when (field) {
            is FormField.Text -> !field.required || (getValue(field.key) as? String)?.isNotBlank() == true
            else -> true
        }
    }
}