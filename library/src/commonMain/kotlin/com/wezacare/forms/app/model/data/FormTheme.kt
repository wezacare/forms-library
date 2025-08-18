package com.wezacare.forms.app.model.data

import androidx.compose.ui.graphics.Color
import com.wezacare.forms.core.parseHexColor
import com.wezacare.forms.core.presentation.formVioletPrimary
import kotlinx.serialization.Serializable

@Serializable
data class FormTheme(
    private val primaryColor: String = formVioletPrimary.toString(),
    val headerImage: HeaderImage? = null,
) {
    val _primaryColor get() = Color(parseHexColor(primaryColor))

    @Serializable
    data class HeaderImage(
        val url: String
    )
}
