package com.wezacare.forms.app.pagers

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.wezacare.forms.app.model.FormField
import com.wezacare.forms.app.model.MultiPageForm
import com.wezacare.forms.core.presentation.DEFAULT_FORM_COLOR

@Composable
fun VerticalFormPager(
    form: MultiPageForm,
    onSubmit: () -> Unit,
    values: MutableMap<String, Any> = remember { mutableStateMapOf() },
    errors: MutableMap<String, String?> = remember { mutableStateMapOf() },
) {
    fun validateAllPage(): Boolean {
        var valid = true
        errors.clear()

        form.pages.forEach { page ->
            page.components.forEach { component ->
                if(component is FormField) {
                    val value = values[component.id]
                    val error = component.validate(value)
                    errors[component.id] = error
                    if(error != null) valid = false
                }
            }
        }

        return valid
    }

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .background(DEFAULT_FORM_COLOR.copy(alpha = 0.07f))
            .padding(16.dp)
    ) {
        itemsIndexed(form.pages) { index, page ->
            page.components.forEach { element ->
                element.Render(values, { id, value -> values[id] = value }, errors)
            }
            if(index != form.pages.lastIndex) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, bottom = 24.dp),
                    text = "After section ${index + 1} Continue to next section"
                )
            }

        }

        item {
            Spacer(Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextButton(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    colors = ButtonDefaults.outlinedButtonColors().copy(
                        containerColor = Color.White
                    ),
                    shape = MaterialTheme.shapes.medium,
                    onClick = {
                        if (validateAllPage()) {
                            onSubmit()
                        }
                    }
                ) {
                    Text(
                        text = "Submit",
                        color = DEFAULT_FORM_COLOR
                    )

                }

                TextButton(
                    onClick = {
                        values.clear()
                    },
                ) {
                    Text(
                        text = "Clear Form",
                        color = DEFAULT_FORM_COLOR
                    )
                }
            }

        }
    }
}