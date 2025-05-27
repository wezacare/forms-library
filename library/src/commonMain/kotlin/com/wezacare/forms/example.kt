package com.wezacare.forms

import androidx.compose.runtime.Composable
import com.wezacare.forms.app.DynamicForm
import com.wezacare.forms.app.components.FormCheckBoxInput
import com.wezacare.forms.app.components.FormElement
import com.wezacare.forms.app.components.FormGroup
import com.wezacare.forms.app.components.FormGroupHeader
import com.wezacare.forms.app.components.FormTextInput


@Composable
fun FormScreen() {


    val formSchema = listOf(
        FormGroupHeader(id = "header", title = "Nutritional and Diet Plan Form",
            description = "The Wezacare Education plan is designed for online and in-person " +
                    "classrooms and educational programs. We need a few more details to verify that you're" +
                    "a student or educator in an eligible school or course",
        ),
//        FormTextInput(id="name", label = "What is your Full Name?", placeholder = "Your name", value="", onValueChange = {}),
        FormTextInput(id="email", label = "What is your Email Address?", placeholder = "Your Email Address", value="", onValueChange = {}),
        FormGroup(id = "", title = "Demographic Information", children = listOf(
            FormTextInput(id = "", required = true, label = "What is your first name?", placeholder = "Your answer", value = "", onValueChange = {}) as FormElement<Any>,
            FormTextInput(id = "", label = "What is your Age?", placeholder = "Your answer", value = "", onValueChange = {}) as FormElement<Any>
        )),
        FormCheckBoxInput(id = "", required = true, label = "Which of the following individuals reside in your household", subLabel = "(Select all that apply)",
            optionList = listOf("Parent(s)", "Siblings", "Other Relatives", "Guardian"), onValueChange = {}
        )

    )

    DynamicForm(formSchema as List<FormElement<Any>>)

}