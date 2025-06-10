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

public val MyIconPack.Checkbox: ImageVector
    get() {
        if (_checkbox != null) {
            return _checkbox!!
        }
        _checkbox = Builder(name = "Checkbox", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 960.0f, viewportHeight = 960.0f).apply {
            path(fill = SolidColor(Color(0xFFe3e3e3)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveToRelative(424.62f, 565.04f)
                lineToRelative(-99.41f, -99.4f)
                quadToRelative(-5.56f, -5.18f, -12.98f, -5.56f)
                quadToRelative(-7.42f, -0.39f, -13.61f, 5.61f)
                quadToRelative(-6.2f, 6.0f, -6.2f, 13.23f)
                reflectiveQuadToRelative(6.21f, 13.06f)
                lineToRelative(104.41f, 104.41f)
                quadToRelative(9.09f, 9.26f, 21.52f, 9.26f)
                reflectiveQuadToRelative(21.94f, -9.19f)
                lineToRelative(216.62f, -216.61f)
                quadToRelative(5.23f, -5.23f, 5.61f, -12.85f)
                quadToRelative(0.39f, -7.62f, -5.81f, -13.62f)
                quadToRelative(-6.19f, -6.0f, -13.23f, -6.0f)
                reflectiveQuadToRelative(-12.9f, 5.87f)
                lineTo(424.62f, 565.04f)
                close()
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
                moveTo(202.46f, 202.46f)
                lineTo(202.46f, 757.54f)
                lineTo(202.46f, 202.46f)
                close()
            }
        }
        .build()
        return _checkbox!!
    }

private var _checkbox: ImageVector? = null
