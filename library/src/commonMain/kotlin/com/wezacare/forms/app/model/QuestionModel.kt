package com.wezacare.forms.app.model

import kotlinx.serialization.Serializable

@Serializable
data class QuestionModel(
    val id: String,
    val pageId: String,
    val type: String,
    val label: String,
    val required: Boolean,
    val description: String,
    val placeholder: String? = null,
    val options: List<QuestionOption>? = null
) {
    @Serializable
    data class QuestionOption(
        val label: String,
        val value: String
    )
}


