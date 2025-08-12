package com.wezacare.forms.app.model

import androidx.compose.ui.graphics.Color
import com.wezacare.forms.core.parseHexColor
import com.wezacare.forms.core.presentation.formVioletPrimary
import kotlinx.serialization.Serializable

@Serializable
data class FormTheme(
    private val primaryColor: String = formVioletPrimary.toString(),
    private val backgroundColor: String = Color.White.toString(),
    private val textColor: String = Color.Black.toString(),
    val fontFamily: String? = null,
    val headerImage: HeaderImage? = null,
) {
    val _primaryColor get() = Color(parseHexColor(primaryColor))
    val _backgroundColor get() = Color(parseHexColor(backgroundColor))
    val _textColor get() = Color(parseHexColor(textColor))

    @Serializable
    data class HeaderImage(
        val url: String
    )
}
