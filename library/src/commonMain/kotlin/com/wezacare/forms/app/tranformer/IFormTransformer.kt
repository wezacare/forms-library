package com.wezacare.forms.app.tranformer

import com.wezacare.forms.app.model.FormField
import com.wezacare.forms.app.model.QuestionModel

interface IFormTransformer {
    val question: QuestionModel
    val type: FormType
    fun transform(): FormField<Any>
}