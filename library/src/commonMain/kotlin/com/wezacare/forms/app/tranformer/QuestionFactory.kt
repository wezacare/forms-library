package com.wezacare.forms.app.tranformer

import com.wezacare.forms.app.components.FormCheckBoxInput
import com.wezacare.forms.app.components.FormDropDown
import com.wezacare.forms.app.components.FormOptionInput
import com.wezacare.forms.app.components.FormTextInput
import com.wezacare.forms.app.model.FormElement
import com.wezacare.forms.app.model.FormField
import com.wezacare.forms.app.model.QuestionModel

object QuestionFactory {
    fun createFormComponent(questionModel: QuestionModel): IFormTransformer? {
        return when(questionModel.type) {
            "short-text" -> FormTextInput.Transformer(questionModel)
            "long-text" -> FormTextInput.Transformer(questionModel)
            "dropdown" -> FormDropDown.Transformer(questionModel)
            "checkbox" -> FormCheckBoxInput.Transformer(questionModel)
            "multiple-choice" -> FormOptionInput.Transformer(questionModel)
            else -> return null
        }
    }
}