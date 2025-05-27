package com.wezacare.forms.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wezacare.forms.app.components.FormElement
import com.wezacare.forms.app.components.FormField
import com.wezacare.forms.app.components.FormGroup

@Composable
fun DynamicForm(
    elements: List<FormElement<Any>>
) {
    val formState = remember { mutableStateMapOf<String, String>() }
    val errorState = remember { mutableStateMapOf<String, String?>() }

    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {

        items(elements) { element ->
            element.Render(formState.toMutableMap(), errorState.toMutableMap())
            Spacer(Modifier.size(12.dp))
        }
        item {
            Button(onClick = {
                val valid = validateAll(elements, formState, errorState)
                if (valid) {
                    println("Submitted: $formState")
                }
            }) {
                Text("Submit")
            }
        }
    }
}

private fun validateAll(
    elements: List<FormElement<Any>>,
    formState: MutableMap<String, String>,
    errorState: MutableMap<String, String?>
): Boolean {
    var allValid = true

    elements.forEach { formElement ->
        when(formElement) {
            is FormField -> {
                val value = formState[formElement.id] ?: ""
                val error = formElement.validate(value)
                errorState[formElement.id] = error
                if (error != null) allValid = false
            }
            is FormGroup -> {
                val valid = validateAll(formElement.children, formState, errorState)
                if (!valid) allValid = false
            }
            else -> {

            }
        }
    }

    return allValid
}