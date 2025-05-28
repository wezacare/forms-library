package com.wezacare.forms.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
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
import com.wezacare.forms.app.model.FormElement
import com.wezacare.forms.app.model.FormField
import com.wezacare.forms.app.model.ValidationRule
import com.wezacare.forms.core.presentation.FormBorderGray

data class FormGroup(
    override val id: String,
    override val label: String,
    val children: List<FormField<Any>> = emptyList()
): FormField<Any> {
    override val placeholder: String? = null
    override val required: Boolean = false
    override val validators: List<ValidationRule> = emptyList()

    override fun validate(value: Any): String? = null

    @Composable
    override fun Render(
        values: Map<String, Any>,
        onValueChange: (String, Any) -> Unit,
        errors: Map<String, String?>
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
                text = label,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.size(8.dp))
            children.forEach { child ->
                child.Render(values, onValueChange, errors)
                Spacer(modifier = Modifier.size(8.dp))
            }
        }
    }
}