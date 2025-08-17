package com.wezacare.forms.app.model.data

data class FormSchema(
    val id: String,
    val title: String,
    val description: String,
    val redirectUrl: String,
    val thumbnail: String,
    val isVerticalScroll: Boolean,
    val isPublished: Boolean,
    val isPublic: Boolean,
    val organisationId: String,
    val createdBy: String,
    val createdAt: String,
    val updatedAt: String,
    val theme: FormTheme?,
    val pages: List<PageModel>,
    val questions: List<QuestionModel>,
    val completed: Boolean = false
)
