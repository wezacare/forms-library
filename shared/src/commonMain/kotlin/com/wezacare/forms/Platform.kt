package com.wezacare.forms

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform