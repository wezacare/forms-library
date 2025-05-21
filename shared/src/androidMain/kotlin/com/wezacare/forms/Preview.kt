package com.wezacare.forms

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.wezacare.forms.components.FormInputText

@Preview(showBackground = true)
@Composable
private fun PreviewFormInputText() {
    FormInputText(
        title = "What is your first name?",
        value = "",
        placeholder = "Your answer",
        onValueChange = {}
    )
}