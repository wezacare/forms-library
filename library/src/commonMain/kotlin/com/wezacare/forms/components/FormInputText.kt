package com.wezacare.forms.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.wezacare.forms.core.presentation.bottomBorder

@Composable
fun FormInputText(
    title: String,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
            .background(Color.Transparent, MaterialTheme.shapes.small)
            .clip(MaterialTheme.shapes.small)
            .padding(vertical = 12.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.size(3.dp))

        BasicTextField(
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 6.dp)
                .bottomBorder(1.dp, Color.Gray.copy(alpha = 0.8f)),
            value = value,
            onValueChange = onValueChange,
            cursorBrush = SolidColor(Color.DarkGray),
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier.padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    if(value.isBlank()) {
                        Text(
                            text = placeholder ?: "",
                            color = Color.Gray.copy(alpha = 0.8f)
                        )
                    } else {
                        innerTextField()
                    }
                }

            }
        )
    }
}

