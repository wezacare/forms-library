package com.wezacare.forms.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.wezacare.forms.core.presentation.FormBorderGray
import com.wezacare.forms.core.presentation.FormErrorRed

@Composable
fun FormGroup(
    title: String,
    modifier: Modifier = Modifier,
    inputComposable: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .background(Color.Gray.copy(0.1f), MaterialTheme.shapes.large)
            .clip(MaterialTheme.shapes.large)
            .border(0.7.dp, FormBorderGray, MaterialTheme.shapes.large)
            .padding(start = 8.dp, top = 12.dp, bottom = 8.dp, end = 8.dp)
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = title,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.size(8.dp))
        inputComposable()
    }
}

