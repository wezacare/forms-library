package com.wezacare.forms.app.model.data

import kotlinx.serialization.Serializable

@Serializable
data class PageModel(
    val id: String,
    val title: String,
    val order: Int,
    val formId: String?
)
