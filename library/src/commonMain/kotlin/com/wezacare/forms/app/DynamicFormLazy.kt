package com.wezacare.forms.app

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DynamicFormLazy(
    fields: List<FormField>,
    formState: FormState
) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(fields) { field ->
            FormFieldRenderer(field, formState)
            Spacer(modifier = Modifier.size(8.dp))
        }
    }
}