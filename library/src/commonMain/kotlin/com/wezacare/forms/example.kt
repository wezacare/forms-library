package com.wezacare.forms

import androidx.compose.runtime.Composable
import com.wezacare.forms.app.DynamicForm
import com.wezacare.forms.app.model.FormElement
import com.wezacare.forms.app.components.FormGroup
import com.wezacare.forms.app.components.FormGroupHeader
import com.wezacare.forms.app.components.FormOptionInput
import com.wezacare.forms.app.components.FormCheckBoxInput
import com.wezacare.forms.app.components.FormTextInput
import com.wezacare.forms.app.model.FormField


@Composable
fun FormScreen() {


    val formSchema = listOf(
        FormGroupHeader(id = "header", title = "Nutritional and Diet Plan Form",
            description = "The Wezacare Education plan is designed for online and in-person " +
                    "classrooms and educational programs. We need a few more details to verify that you're" +
                    "a student or educator in an eligible school or course",
        ),
//        FormTextInput(id="name", label = "What is your Full Name?", placeholder = "Your name", value=""),
        FormTextInput(id="email", label = "What is your Email Address?", placeholder = "Your Email Address", required = true),
        FormGroup(id = "demographic", label = "Demographic Information", children = listOf(
            FormTextInput(id = "firstName", required = true, label = "What is your first name?", placeholder = "Your answer") as FormField<Any>,
            FormTextInput(id = "age", label = "What is your Age?", placeholder = "Your answer") as FormField<Any>
        )
        ),
//        FormOptionInput(id = "option", required = true, label = "On a scale from 1 to 5, how would you rate your current level of education",
//            subLabel = "(1 being the lowest, 5 being the highest)", optionList = listOf("1", "2", "3", "4", "5")
//        )
        FormCheckBoxInput(id = "checkbox", required = true, label = "Which of the following individuals reside in your household",
            subLabel = "(Select all that apply)", optionList = listOf("Parent(s)", "Siblings", "Other Relatives", "Guardian")
        )

    )

    DynamicForm(formSchema as List<FormElement<Any>>)

}