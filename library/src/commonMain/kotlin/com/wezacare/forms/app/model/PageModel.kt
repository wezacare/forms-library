package com.wezacare.forms.app.model

import kotlinx.serialization.Serializable

@Serializable
data class PageModel(
    val id: String,
    val title: String,
    val order: Int,
    val formId: String
)
