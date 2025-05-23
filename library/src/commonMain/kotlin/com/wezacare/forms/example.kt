package com.wezacare.forms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wezacare.forms.app.DynamicFormLazy
import com.wezacare.forms.app.FormField
import com.wezacare.forms.app.FormState


@Composable
fun FormScreen() {
    val formSchema: List<FormField> = listOf(
        FormField.Banner(title = "Nutritional and Diet Plan Form",
            description = "The Wezacare Education plan is designed for online and in-person " +
                    "classrooms and educational programs. We need a few more details to verify that you're" +
                    "a student or educator in an eligible school or course",
            key = "banner"
        ),
        FormField.Text(label = "What is your full name", key = "full_name", required = true),
        FormField.Text(label = "What is your email address", key = "email", required = true)
    )

    val formState = FormState(formSchema)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        DynamicFormLazy(
            fields = formSchema,
            formState = formState
        )
    }

}