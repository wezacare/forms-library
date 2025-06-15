package com.wezacare.forms.core

import androidx.compose.runtime.Composable
import com.wezacare.forms.core.models.PermissionStatus
import com.wezacare.forms.core.models.PermissionType

expect class PermissionManager(callback: PermissionCallback ) {
    @Composable
    fun askPermission(permission: PermissionType)
    
    @Composable
    fun isPermissionGranted(permission: PermissionType): Boolean
    
    @Composable
    fun launchSettings()
}

interface PermissionCallback {
    fun onPermissionStatus(permissionType: PermissionType, status: PermissionStatus)
}

@Composable
expect fun createPermissionManager(callback: PermissionCallback): PermissionManager

