package com.wezacare.forms.app.tranformer

import com.wezacare.forms.app.components.formtypes.FormCheckBoxInput
import com.wezacare.forms.app.components.formtypes.FormDropDown
import com.wezacare.forms.app.components.formtypes.FormOptionInput
import com.wezacare.forms.app.components.formtypes.FormTextInput
import com.wezacare.forms.app.model.data.FormTheme
import com.wezacare.forms.app.model.data.QuestionModel

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