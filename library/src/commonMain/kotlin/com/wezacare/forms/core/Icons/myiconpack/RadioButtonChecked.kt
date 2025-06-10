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

public val MyIconPack.RadioButtonChecked: ImageVector
    get() {
        if (_radioButtonChecked != null) {
            return _radioButtonChecked!!
        }
        _radioButtonChecked = Builder(name = "RadioButtonChecked", defaultWidth = 24.0.dp,
                defaultHeight = 24.0.dp, viewportWidth = 960.0f, viewportHeight = 960.0f).apply {
            path(fill = SolidColor(Color(0xFFe3e3e3)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(480.0f, 635.69f)
                quadToRelative(65.12f, 0.0f, 110.4f, -45.29f)
                quadToRelative(45.29f, -45.28f, 45.29f, -110.4f)
                reflectiveQuadTo(590.4f, 369.6f)
                quadToRelative(-45.28f, -45.29f, -110.4f, -45.29f)
                reflectiveQuadTo(369.6f, 369.6f)
                quadToRelative(-45.29f, 45.28f, -45.29f, 110.4f)
                reflectiveQuadToRelative(45.29f, 110.4f)
                quadToRelative(45.28f, 45.29f, 110.4f, 45.29f)
                close()
                moveTo(480.18f, 833.85f)
                quadToRelative(-73.39f, 0.0f, -138.06f, -27.89f)
                reflectiveQuadToRelative(-112.51f, -75.69f)
                quadToRelative(-47.84f, -47.81f, -75.65f, -112.29f)
                quadToRelative(-27.81f, -64.48f, -27.81f, -137.8f)
                quadToRelative(0.0f, -73.39f, 27.89f, -138.06f)
                reflectiveQuadToRelative(75.69f, -112.51f)
                quadToRelative(47.81f, -47.84f, 112.29f, -75.65f)
                quadToRelative(64.48f, -27.81f, 137.8f, -27.81f)
                quadToRelative(73.39f, 0.0f, 138.06f, 27.89f)
                reflectiveQuadToRelative(112.51f, 75.69f)
                quadToRelative(47.84f, 47.8f, 75.65f, 112.29f)
                quadToRelative(27.81f, 64.48f, 27.81f, 137.8f)
                quadToRelative(0.0f, 73.39f, -27.89f, 138.06f)
                reflectiveQuadToRelative(-75.69f, 112.51f)
                quadToRelative(-47.8f, 47.84f, -112.29f, 75.65f)
                quadToRelative(-64.48f, 27.81f, -137.8f, 27.81f)
                close()
                moveTo(479.97f, 796.92f)
                quadToRelative(132.3f, 0.0f, 224.63f, -92.3f)
                quadToRelative(92.32f, -92.3f, 92.32f, -224.59f)
                quadToRelative(0.0f, -132.3f, -92.3f, -224.63f)
                quadToRelative(-92.3f, -92.32f, -224.59f, -92.32f)
                quadToRelative(-132.3f, 0.0f, -224.63f, 92.3f)
                quadToRelative(-92.32f, 92.3f, -92.32f, 224.59f)
                quadToRelative(0.0f, 132.3f, 92.3f, 224.63f)
                quadToRelative(92.3f, 92.32f, 224.59f, 92.32f)
                close()
            }
        }
        .build()
        return _radioButtonChecked!!
    }

private var _radioButtonChecked: ImageVector? = null
