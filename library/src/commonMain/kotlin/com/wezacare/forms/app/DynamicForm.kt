package com.wezacare.forms.app

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wezacare.forms.app.model.FormElement
import com.wezacare.forms.app.model.FormField
import com.wezacare.forms.app.components.FormGroup

@Composable
fun DynamicForm(
    elements: List<FormElement<Any>>,
) {
    val formState = remember { mutableStateMapOf<String, Any>() }
    val errorState = remember { mutableStateMapOf<String, String?>() }

    fun validateForm(): Boolean {
        errorState.clear()
        var valid = true

        for(component in elements) {
            if(component is FormField) {
                val value = formState[component.id] as Any
                val error = component.validate(value)
                errorState[component.id] = error
                if (error != null) valid = false
            }
        }
        return valid
    }

    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        item {
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "Form Data: -> ${formState}"
            )
        }

        items(elements) { element ->
            element.Render(formState, { id, value -> formState[id] = value }, errorState)
            Spacer(Modifier.size(12.dp))
        }
        item {
            var isValid = true
            Button(onClick = {
                val valid = validateForm()
                isValid = valid
                if (valid) {
                    println("Submitted: $formState")
                }
            }) {
                Text("Submit, $isValid")
            }
        }
    }
}

