package com.wezacare.forms.core.Icons.myiconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.wezacare.forms.core.Icons.MyIconPack

public val MyIconPack.CheckboxBlank: ImageVector
    get() {
        if (_checkboxBlank != null) {
            return _checkboxBlank!!
        }
        _checkboxBlank = Builder(name = "CheckboxBlank", defaultWidth = 24.0.dp, defaultHeight =
                24.0.dp, viewportWidth = 960.0f, viewportHeight = 960.0f).apply {
            path(fill = SolidColor(Color(0xFFe3e3e3)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(226.89f, 794.46f)
                quadToRelative(-25.75f, 0.0f, -43.55f, -17.8f)
                quadToRelative(-17.8f, -17.8f, -17.8f, -43.55f)
                verticalLineToRelative(-506.22f)
                quadToRelative(0.0f, -25.75f, 17.8f, -43.55f)
                quadToRelative(17.8f, -17.8f, 43.55f, -17.8f)
                horizontalLineToRelative(506.22f)
                quadToRelative(25.75f, 0.0f, 43.55f, 17.8f)
                quadToRelative(17.8f, 17.8f, 17.8f, 43.55f)
                verticalLineToRelative(506.22f)
                quadToRelative(0.0f, 25.75f, -17.8f, 43.55f)
                quadToRelative(-17.8f, 17.8f, -43.55f, 17.8f)
                lineTo(226.89f, 794.46f)
                close()
                moveTo(227.08f, 757.54f)
                horizontalLineToRelative(505.84f)
                quadToRelative(9.23f, 0.0f, 16.93f, -7.69f)
                quadToRelative(7.69f, -7.7f, 7.69f, -16.93f)
                verticalLineToRelative(-505.84f)
                quadToRelative(0.0f, -9.23f, -7.69f, -16.93f)
                quadToRelative(-7.7f, -7.69f, -16.93f, -7.69f)
                lineTo(227.08f, 202.46f)
                quadToRelative(-9.23f, 0.0f, -16.93f, 7.69f)
                quadToRelative(-7.69f, 7.7f, -7.69f, 16.93f)
                verticalLineToRelative(505.84f)
                quadToRelative(0.0f, 9.23f, 7.69f, 16.93f)
                quadToRelative(7.7f, 7.69f, 16.93f, 7.69f)
                close()
            }
        }
        .build()
        return _checkboxBlank!!
    }

private var _checkboxBlank: ImageVector? = null
