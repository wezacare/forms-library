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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Reply
import androidx.compose.material.icons.automirrored.filled.Undo
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardReturn
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material.icons.filled.Reply
import androidx.compose.material.icons.filled.Undo
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.wezacare.forms.app.model.FormField
import com.wezacare.forms.app.model.MultiPageForm
import com.wezacare.forms.core.presentation.DEFAULT_FORM_COLOR
import com.wezacare.forms.core.presentation.FormBorderGray

@Composable
fun HorizontalFormPager(
    form: MultiPageForm,
    onSubmit: () -> Unit,
    onBackClick: () -> Unit,
    values: MutableMap<String, Any> = remember { mutableStateMapOf() },
    errors: MutableMap<String, String?> = remember { mutableStateMapOf() },
) {
    var currentPageIndex by remember { mutableStateOf(0) }
    val currentPage = form.pages[currentPageIndex]

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
        modifier = Modifier
            .fillMaxSize()
            .background(DEFAULT_FORM_COLOR.copy(alpha = 0.07f))
            .padding(16.dp)
    ) {
        item {
            TextButton(
                border = BorderStroke(
                    0.5.dp,
                    FormBorderGray,
                ),
                colors = ButtonDefaults.outlinedButtonColors().copy(
                    containerColor = Color.White
                ),
                shape = MaterialTheme.shapes.extraLarge,
                onClick = {
                    onBackClick()
                }
            ) {
                Icon(
                    modifier = Modifier,
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "",
                    tint = Color.Black
                )
                Text(
                    text = "Back",
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.size(4.dp))
        }

        items(currentPage.components) { element ->
            element.Render(values, { id, value -> values[id] = value }, errors)
        }

        item {
            Spacer(Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row {
                    if (currentPageIndex > 0) {
                        TextButton(
                            modifier = Modifier.padding(end = 16.dp),
                            contentPadding = PaddingValues(horizontal = 16.dp),
                            colors = ButtonDefaults.outlinedButtonColors().copy(
                                containerColor = DEFAULT_FORM_COLOR.copy(alpha = 0.3f)
                            ),
                            shape = MaterialTheme.shapes.medium,
                            onClick = { currentPageIndex-- }
                        ) {
                            Text(
                                text = "Back",
                                color = DEFAULT_FORM_COLOR
                            )
                        }
                    }

                    TextButton(
                        contentPadding = PaddingValues(horizontal = 16.dp),
                        colors = ButtonDefaults.outlinedButtonColors().copy(
                            containerColor = Color.White
                        ),
                        shape = MaterialTheme.shapes.medium,
                        onClick = {
                            if (validatePage()) {
                                if (currentPageIndex < form.pages.lastIndex) {
                                    currentPageIndex++
                                } else {
                                    onSubmit()
                                    println("Final submission: $values")
                                }
                            }
                        }
                    ) {
                        Text(
                            text = if (currentPageIndex == form.pages.lastIndex) "Submit" else "Next",
                            color = DEFAULT_FORM_COLOR
                        )

                    }

                }

                TextButton(
                    onClick = {
                        values.clear()
                    }
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