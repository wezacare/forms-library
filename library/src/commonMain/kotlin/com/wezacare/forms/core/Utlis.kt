package com.wezacare.forms.core

fun parseHexColor(hexString: String): Int {
    var cleanHexString = hexString.removePrefix("#")

    if (cleanHexString.length == 3) {
        cleanHexString = cleanHexString.map { it.toString().repeat(2) }.joinToString("")
    }

    if (cleanHexString.length == 6) {
        cleanHexString = "FF$cleanHexString"
    }

    return cleanHexString.toULong(radix = 16).toInt()
}