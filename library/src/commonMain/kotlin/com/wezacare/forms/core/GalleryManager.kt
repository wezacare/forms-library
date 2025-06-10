package com.wezacare.forms.core

import androidx.compose.runtime.Composable
import com.wezacare.forms.core.models.SharedImage

@Composable
expect fun rememberGalleryManager(onResult: (SharedImage?) -> Unit): GalleryManager

expect class GalleryManager(
    onLaunch: () -> Unit
) {
    fun launch()
}