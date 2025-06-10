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

public val MyIconPack.Videocam: ImageVector
    get() {
        if (_videocam != null) {
            return _videocam!!
        }
        _videocam = Builder(name = "Videocam", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 960.0f, viewportHeight = 960.0f).apply {
            path(fill = SolidColor(Color(0xFFe3e3e3)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(208.04f, 754.46f)
                quadToRelative(-26.35f, 0.0f, -43.94f, -17.8f)
                quadToRelative(-17.6f, -17.8f, -17.6f, -43.58f)
                verticalLineToRelative(-426.16f)
                quadToRelative(0.0f, -25.78f, 17.6f, -43.58f)
                quadToRelative(17.59f, -17.8f, 43.94f, -17.8f)
                horizontalLineToRelative(426.01f)
                quadToRelative(25.77f, 0.0f, 43.57f, 17.8f)
                reflectiveQuadToRelative(17.8f, 43.74f)
                verticalLineToRelative(186.77f)
                lineTo(787.27f, 362.0f)
                quadToRelative(7.08f, -7.08f, 16.85f, -3.49f)
                quadToRelative(9.76f, 3.59f, 9.76f, 13.8f)
                verticalLineToRelative(215.54f)
                quadToRelative(0.0f, 9.98f, -9.76f, 13.61f)
                quadToRelative(-9.77f, 3.62f, -16.85f, -3.46f)
                lineToRelative(-91.85f, -91.85f)
                verticalLineToRelative(186.77f)
                quadToRelative(0.0f, 25.94f, -17.8f, 43.74f)
                reflectiveQuadToRelative(-43.57f, 17.8f)
                lineTo(208.04f, 754.46f)
                close()
                moveTo(208.04f, 717.54f)
                horizontalLineToRelative(425.84f)
                quadToRelative(10.39f, 0.0f, 17.5f, -6.92f)
                quadToRelative(7.12f, -6.93f, 7.12f, -17.7f)
                verticalLineToRelative(-425.84f)
                quadToRelative(0.0f, -10.77f, -7.12f, -17.7f)
                quadToRelative(-7.11f, -6.92f, -17.5f, -6.92f)
                lineTo(208.04f, 242.46f)
                quadToRelative(-10.77f, 0.0f, -17.69f, 6.92f)
                quadToRelative(-6.93f, 6.93f, -6.93f, 17.7f)
                verticalLineToRelative(425.84f)
                quadToRelative(0.0f, 10.77f, 6.93f, 17.7f)
                quadToRelative(6.92f, 6.92f, 17.69f, 6.92f)
                close()
                moveTo(183.42f, 717.54f)
                verticalLineToRelative(-475.08f)
                verticalLineToRelative(475.08f)
                close()
            }
        }
        .build()
        return _videocam!!
    }

private var _videocam: ImageVector? = null
