package com.wezacare.forms.app.tranformer

import com.wezacare.forms.app.components.FormCheckBoxInput
import com.wezacare.forms.app.components.FormDropDown
import com.wezacare.forms.app.components.FormOptionInput
import com.wezacare.forms.app.components.FormTextInput
import com.wezacare.forms.app.model.FormElement
import com.wezacare.forms.app.model.FormField
import com.wezacare.forms.app.model.FormTheme
import com.wezacare.forms.app.model.QuestionModel

object QuestionFactory {
    fun createFormComponent(questionModel: QuestionModel, formTheme: FormTheme?): IFormTransformer? {
        return when(questionModel.type) {
            "short-text" -> FormTextInput.Transformer(questionModel, formTheme)
            "long-text" -> FormTextInput.Transformer(questionModel, formTheme)
            "dropdown" -> FormDropDown.Transformer(questionModel, formTheme)
            "checkbox" -> FormCheckBoxInput.Transformer(questionModel, formTheme)
            "multiple-choice" -> FormOptionInput.Transformer(questionModel, formTheme)
            else -> return null
        }
    }
}