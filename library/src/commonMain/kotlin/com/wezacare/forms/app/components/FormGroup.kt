package com.wezacare.forms.app.components

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
import com.wezacare.forms.app.model.ValidationRule
import com.wezacare.forms.core.presentation.FormBorderGray

data class FormGroup(
    override val id: String,
    val title: String,
    val children: List<FormElement<Any>> = emptyList()
): FormElement<Any> {
    @Composable
    override fun Render(
        formState: MutableMap<String, Any>,
        errorState: MutableMap<String, String?>
    ) {
        Column(
            modifier = Modifier
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
            children.forEach { child ->
                child.Render(formState, errorState)
                Spacer(modifier = Modifier.size(8.dp))
            }
        }
    }
}