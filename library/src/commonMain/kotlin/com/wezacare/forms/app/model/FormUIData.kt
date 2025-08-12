package com.wezacare.forms.app.model

import kotlinx.serialization.Serializable

@Serializable
data class FormUIData(
    val id: String,
    val title: String,
    val description: String,
    val thumbnailUrl: String,
    val redirectUrl: String,
    val theme: FormTheme,
    val isVerticalScroll: Boolean,
    val createAt: String,
    val updateAt: String,
    val pages: List<PageModel>,
    val questions: List<QuestionModel>
)
