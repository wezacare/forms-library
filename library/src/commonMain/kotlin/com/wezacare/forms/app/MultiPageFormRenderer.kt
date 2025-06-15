package com.wezacare.forms.app

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.wezacare.forms.app.components.FormGroupHeader
import com.wezacare.forms.app.model.FormField
import com.wezacare.forms.app.model.MultiPageForm
import com.wezacare.forms.core.presentation.FormBorderGray

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
                val value = values[component.id]
                val error = component.validate(value)
                errors[component.id] = error
                if(error != null) valid = false
            }
        }
        return valid
    }

    LazyColumn (
        modifier = Modifier.padding(16.dp)
    ) {
        item {
            FormGroupHeader(
                id = currentPage.id,
                title = currentPage.title,
                description = currentPage.description ?: "",
                pageTitle = "Page ${currentPageIndex + 1 } of ${form.pages.size }"
            ).Render(values, {_, _ ->  }, errors)

            Spacer(Modifier.height(16.dp))
        }

        items(currentPage.components) { element ->
            element.Render(values, { id, value -> values[id] = value }, errors)
            Spacer(Modifier.size(12.dp))
        }

        item {
            Spacer(Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                if (currentPageIndex > 0) {
                    OutlinedButton(
                        modifier = Modifier.padding(end = 16.dp),
                        border = BorderStroke(1.dp, FormBorderGray),
                        contentPadding = PaddingValues(horizontal = 12.dp),
                        colors = ButtonDefaults.outlinedButtonColors().copy(
                            contentColor = Color.DarkGray
                        ),
                        shape = MaterialTheme.shapes.extraSmall,
                        onClick = { currentPageIndex-- }
                    ) {

                        Icon(
                            modifier = Modifier.padding(end = 8.dp),
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = ""
                        )
                        Text("Previous Page")


                    }
                }

                OutlinedButton(
                    border = BorderStroke(1.dp, FormBorderGray),
                    contentPadding = PaddingValues(horizontal = 12.dp),
                    colors = ButtonDefaults.outlinedButtonColors().copy(
                        contentColor = Color.DarkGray
                    ),
                    shape = MaterialTheme.shapes.extraSmall,
                    onClick = {
                    if (validatePage()) {
                        if (currentPageIndex < form.pages.lastIndex) {
                            currentPageIndex++
                        } else {
                            println("Final submission: $values")
                        }
                    }
                }) {
                    Text(if (currentPageIndex == form.pages.lastIndex) "Submit" else "Next Page")
                    
                    if (currentPageIndex != form.pages.lastIndex) {
                        Icon(
                            modifier = Modifier.padding(start = 8.dp),
                            imageVector = Icons.AutoMirrored.Default.ArrowForward,
                            contentDescription = ""
                        )
                    }

                }
            }
        }


    }

}