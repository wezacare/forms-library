package com.wezacare.forms

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.wezacare.forms.app.DynamicForm
import com.wezacare.forms.app.MultiPageFormRenderer
import com.wezacare.forms.app.pagers.HorizontalFormPager
import com.wezacare.forms.app.model.FormElement
import com.wezacare.forms.app.components.FormGroupHeader
import com.wezacare.forms.app.components.FormOptionInput
import com.wezacare.forms.app.components.FormCheckBoxInput
import com.wezacare.forms.app.components.FormDropDown
import com.wezacare.forms.app.components.FormImageInput
import com.wezacare.forms.app.components.FormLinkedDoc
import com.wezacare.forms.app.components.FormTextInput
import com.wezacare.forms.app.model.FormMargin
import com.wezacare.forms.app.model.FormPage
import com.wezacare.forms.app.model.MultiPageForm
import com.wezacare.forms.app.model.NavigationMode


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
//        FormGroup(id = "demographic", label = "Demographic Information", children = listOf(
//            FormTextInput(id = "firstName", required = true, label = "What is your first name?", placeholder = "Your answer") as FormField<Any>,
//            FormTextInput(id = "age", label = "What is your Age?", placeholder = "Your answer") as FormField<Any>
//        )
//        ),
        FormOptionInput(id = "option", required = true, label = "On a scale from 1 to 5, how would you rate your current level of education",
            subLabel = "(1 being the lowest, 5 being the highest)", optionList = listOf("1", "2", "3", "4", "5")
        ),
        FormCheckBoxInput(id = "checkbox", required = true, label = "Which of the following individuals reside in your household",
            subLabel = "(Select all that apply)", optionList = listOf("Parent(s)", "Siblings", "Other Relatives", "Guardian")
        )

    )

    DynamicForm(formSchema as List<FormElement<Any>>)

}


@Composable
fun MultiPageFormScreen() {

    val formComponents: List<FormElement<Any>>  = listOf(
        FormGroupHeader(
            id =  "1",
            title = "Nutrition and Diet Plan Form",
            description = "The Application for Registration of a CCI is designed for online and in-person classrooms and educational programs. We need a few more details to verify that you’re a student or educator in an eligible school or course.",
//                pageTitle = "Page ${currentPageIndex + 1 } of ${form.pages.size }"
        ) as FormElement<Any>,
        FormLinkedDoc(id = "food", "Food Preferences and Restriction", link = "", margin = FormMargin(8.dp, 2.dp)) as FormElement<Any>,
        FormLinkedDoc(id = "lifestyle", title = "Lifestyle and Activity Level", link = "", margin = FormMargin(0.dp, 8.dp)) as FormElement<Any>,
        FormTextInput(id="name", label = "What is your full name", placeholder = "Your Full Name", required = true ) as FormElement<Any>,

        FormCheckBoxInput(id = "checkbox", required = true, label = "Which of the following individuals reside in your household",
            subLabel = "(Select all that apply)", optionList = listOf("Parent(s)", "Siblings", "Other Relatives", "Guardian")
        ) as FormElement<Any>,

        FormImageInput(id = "image", label = "Profile Picture", placeholder = "Select one image from the drive", required = false) as FormElement<Any>
    )

    val page2FormComponents: List<FormElement<Any>> = listOf(
        FormTextInput(
            id="email",
            label = "What is your Email Address?",
            placeholder = "Your Email Address",
            required = true,
            showPageTitle = true,
            pageTitle = "Section 2 of 2",
            margin = FormMargin(top = 8.dp, bottom = 4.dp)
        ) as FormElement<Any>,

        FormOptionInput(id = "option", required = false, label = "On a scale from 1 to 5, how would you rate your current level of education",
            subLabel = "(1 being the lowest, 5 being the highest)", optionList = listOf("1", "2", "3", "4", "5")
        ) as FormElement<Any>,


        FormDropDown(
            id = "ExposedDropDown",
            label = "What is your prefered contact method?",
            subLabel = "Use the dropdown to pick the most reliable way for us to contact you",
            optionList = listOf("Samora", "Machel", "Amisi", "Kevin", "Adrian"),
            placeholder = "Select an option",
            required = true
        ) as FormElement<Any>
    )

    val formSchema = MultiPageForm(
        pages = listOf(
            FormPage(
                page = 1,
                components = formComponents
            ),
            FormPage(
                page = 2,
                components = page2FormComponents
            )
        ),
        navigationMode = NavigationMode.HORIZONTAL
    )

    MultiPageFormRenderer(formSchema, {}, {})
}