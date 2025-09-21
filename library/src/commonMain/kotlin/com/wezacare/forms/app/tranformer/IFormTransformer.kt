package com.wezacare.forms.app.tranformer

import com.wezacare.forms.app.model.ui.FormField
import com.wezacare.forms.app.model.data.FormTheme
import com.wezacare.forms.app.model.data.QuestionModel

interface IFormTransformer {
    val question: QuestionModel
    val type: FormType
    val theme: FormTheme?
    fun transform(sectionTitle: String? = null): FormField<Any>
}