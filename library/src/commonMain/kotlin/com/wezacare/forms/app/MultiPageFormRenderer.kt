package com.wezacare.forms.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wezacare.forms.app.model.FormField
import com.wezacare.forms.app.model.MultiPageForm

@Composable
fun MultiPageFormRenderer(form: MultiPageForm) {
    var currentPageIndex by remember { mutableStateOf(0) }
    val currentPage = form.pages[currentPageIndex]

    val values = remember { mutableStateMapOf<String, Any>() }
    val errors = remember { mutableStateMapOf<String, String?>() }

    fun validatePage(): Boolean {
        errors.clear()
        var valid = true
        for (component in currentPage.components) {
            if(component is FormField) {
                val value = values[component.id] ?: ""
                val error = component.validate(value)
                errors[component.id] = error
                if(error != null) valid = false
            }
        }
        return valid
    }

    Column {
        Text(currentPage.title, style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))

        currentPage.components.forEach {
            it.Render(values, { id, value -> values[id] = value }, errors)
        }

        Spacer(Modifier.height(24.dp))

        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            if (currentPageIndex > 0) {
                Button(onClick = { currentPageIndex-- }) {
                    Text("Previous")
                }
            }

            Button(onClick = {
                if (validatePage()) {
                    if (currentPageIndex < form.pages.lastIndex) {
                        currentPageIndex++
                    } else {
                        println("Final submission: $values")
                    }
                }
            }) {
                Text(if (currentPageIndex == form.pages.lastIndex) "Submit" else "Next")
            }
        }
    }

}