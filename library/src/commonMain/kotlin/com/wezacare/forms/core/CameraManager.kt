package com.wezacare.forms.core

import androidx.compose.runtime.Composable
import com.wezacare.forms.core.models.SharedImage

@Composable
expect fun rememberCameraManager(onResult: (SharedImage?) -> Unit): CameraManager

expect class CameraManager(
    onLaunch: () -> Unit
) {
    fun launch()
}