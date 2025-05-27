package com.wezacare.forms.app.model

typealias ValidationRule = (String) -> String?


object ValidationRules {
    fun minLength(min: Int): ValidationRule = {
        if (it.length < min) "Minimum $min characters required" else null
    }

    fun maxLength(max: Int): ValidationRule = {
        if (it.length > max) "Maximum $max characters allowed" else null
    }

//    fun email(): ValidationRule = {
//        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(it).matches()) "Invalid email address" else null
//    }

    fun numericOnly(): ValidationRule = {
        if (!it.matches(Regex("^[0-9]*$"))) "Only numbers are allowed" else null
    }
}