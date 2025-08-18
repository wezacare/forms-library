package com.wezacare.forms.app.model.data

import com.wezacare.forms.app.components.formtypes.FormOption
import com.wezacare.forms.app.model.data.QuestionModel.QuestionOption
import kotlinx.serialization.Serializable

@Serializable
data class QuestionModel(
    val id: String,
    val pageId: String,
    val type: String,
    val label: String,
    val required: Boolean,
    val description: String,
    val value: String? = null,
    val isFirst: Boolean = false,
    val sectionBanner: String? = null,
    val placeholder: String? = null,
    val options: List<QuestionOption>? = null
) {
    @Serializable
    data class QuestionOption(
        val label: String,
        val value: String
    )


}

fun QuestionOption.toFormOption(): FormOption {
    return FormOption(label, value)
}



