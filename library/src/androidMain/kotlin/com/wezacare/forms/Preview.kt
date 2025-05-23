package com.wezacare.forms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.wezacare.forms.components.FormBanner
import com.wezacare.forms.components.FormCheckBoxInput
import com.wezacare.forms.components.FormGroup
import com.wezacare.forms.components.FormOptionInput
import com.wezacare.forms.components.FormTextInput

@Preview(showBackground = true)
@Composable
private fun PreviewFormInputText() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        FormTextInput(
            title = "What is your first name?",
            value = "",
            placeholder = "Your answer",
            onValueChange = {},
            error = "Field cannot be empty",
            isInputValid = false,
            mandatoryField = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewFormOptionInput() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        FormOptionInput(
            title = "On a scale of 1 to 5, how would you rate your level of education?",
            subTitle = "(1 being lowest, 5 being highest)",
            optionList = listOf("1", "2", "3", "4", "5"),
            selectedOption = 2,
            onOptionClicked = {},
            error = "Field cannot be blank",
            isInputValid = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewFormCheckBoxInput() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        FormCheckBoxInput(
            title = "Which of the following individuals reside in your household",
            subTitle = "(Select all that apply)",
            optionList = listOf("Parent(s)", "Siblings", "Other Relatives", "Guardians"),
            selectedOptions = listOf(1, 2),
            onOptionClicked = {},
            error = "Field cannot be blank",
            isInputValid = true,
            mandatoryField = true
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewFormGroup() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        FormGroup(
            title = "Demographic Information"
        ) {
            FormTextInput(
                title = "What is your first name?",
                value = "",
                placeholder = "Your answer",
                onValueChange = {},
                error = "Field cannot be empty",
                isInputValid = true,
                mandatoryField = true
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewFormBanner() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        FormBanner(
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