package com.wezacare.forms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.wezacare.forms.app.components.FormCheckBoxInput
import com.wezacare.forms.app.components.FormElement
import com.wezacare.forms.app.components.FormGroup
import com.wezacare.forms.app.components.FormGroupHeader
import com.wezacare.forms.app.components.FormOptionInput
import com.wezacare.forms.app.components.FormTextInput




@Preview(showBackground = true)
@Composable
private fun PreviewFormGroup() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        FormGroup(
            id = "",
            title = "Demographic Information",
            children = listOf(
                FormTextInput(id = "", label = "What is your first name?", placeholder = "Your answer", value = "", onValueChange = {} ) as FormElement<Any>
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewFormBanner() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        FormGroupHeader(
            id = "",
            title = "Nutritional and Diet Plan Form",
            description = "The Wezacare Education plan is designed for online and in-person " +
                    "classrooms and educational programs. We need a few more details to verify that you're" +
                    "a student or educator in an eligible school or course"
        )

    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewForm() {
    FormScreen()
}