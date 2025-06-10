package com.wezacare.forms.core.Icons

import androidx.compose.ui.graphics.vector.ImageVector
import com.wezacare.forms.core.Icons.myiconpack.AddPhotoAlternate
import com.wezacare.forms.core.Icons.myiconpack.Checkbox
import com.wezacare.forms.core.Icons.myiconpack.CheckboxBlank
import com.wezacare.forms.core.Icons.myiconpack.RadioButtonChecked
import com.wezacare.forms.core.Icons.myiconpack.RadioButtonUnchecked
import com.wezacare.forms.core.Icons.myiconpack.Videocam
import kotlin.String
import kotlin.collections.List as ____KtList
import kotlin.collections.Map as ____KtMap

public object MyIconPack

private var __AllIcons: ____KtList<ImageVector>? = null

public val MyIconPack.AllIcons: ____KtList<ImageVector>
  get() {
    if (__AllIcons != null) {
      return __AllIcons!!
    }
    __AllIcons= listOf(AddPhotoAlternate, Checkbox, CheckboxBlank, RadioButtonChecked,
        RadioButtonUnchecked, Videocam)
    return __AllIcons!!
  }

private var __AllIconsNamed: ____KtMap<String, ImageVector>? = null

public val MyIconPack.AllIconsNamed: ____KtMap<String, ImageVector>
  get() {
    if (__AllIconsNamed != null) {
      return __AllIconsNamed!!
    }
    __AllIconsNamed= mapOf("addphotoalternate" to AddPhotoAlternate, "checkbox" to Checkbox,
        "checkboxblank" to CheckboxBlank, "radiobuttonchecked" to RadioButtonChecked,
        "radiobuttonunchecked" to RadioButtonUnchecked, "videocam" to Videocam)
    return __AllIconsNamed!!
  }
