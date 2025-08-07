package com.wezacare.forms.app.model

import androidx.compose.ui.graphics.Color
import com.wezacare.forms.core.presentation.formVioletPrimary
import kotlinx.serialization.Serializable

@Serializable
data class FormTheme(
    val primaryColor: String = formVioletPrimary.toString(),
    val backgroundColor: String = Color.White.toString(),
    val textColor: String = Color.Black.toString(),
    val fontFamily: String? = null,
    val headerImage: HeaderImage? = null,
) {
    val _primaryColor get() = Color(primaryColor.toLong(radix = 16))
    val _backgroundColor get() = Color(backgroundColor.toLong(radix = 16))
    val _textColor get() = Color(textColor.toLong(radix = 16))

    @Serializable
    data class HeaderImage(
        val url: String
    )
}
