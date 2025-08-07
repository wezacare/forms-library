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
import com.wezacare.forms.app.model.FormData
import com.wezacare.forms.app.model.FormMargin
import com.wezacare.forms.app.model.FormPage
import com.wezacare.forms.app.model.FormTheme
import com.wezacare.forms.app.model.MultiPageForm
import com.wezacare.forms.app.model.NavigationMode
import com.wezacare.forms.app.model.PageModel
import com.wezacare.forms.app.model.QuestionModel


@Composable
fun MultiPageFormScreen() {

    val formData = FormData(
        id = "form-1",
        title = "Employee Onboarding",
        description = "A form to onboard new employees, collect personal and job-related information.",
        thumbnailUrl = "https://picsum.photos/200/300?random=21",
        redirectUrl = "/app/forms/employee-onboarding/thank-you",
        theme = FormTheme(
            primaryColor = "#2563eb",
            backgroundColor = "#f3f4f6",
            textColor = "#111827",
            headerImage = FormTheme.HeaderImage(url = "https://picsum.photos/600/100?random=1"),
        ),
        isVerticalScroll = true,
        createAt = "2024-06-01T10:00:00Z",
        updateAt = "2024-06-02T12:00:00Z",
        pages = listOf(
            PageModel(
                id = "p1-1",
                title = "Personal Information",
                order = 0,
                formId =  "form-1"
            ),
            PageModel(
                id = "p2-1",
                title = "Personal Information",
                order = 0,
                formId =  "form-1"
            )

        ),
        questions = listOf(
            QuestionModel(
                id = "q1-1",
                pageId = "p1-1",
                type = "short-text",
                label = "First Name",
                required = true,
                description = "Enter your first name."
            ),
            QuestionModel(
                id = "q1-3",
                pageId = "p2-1",
                type = "short-text",
                label = "Department",
                required = true,
                description = "Enter your department."
            )
        )
    )


    MultiPageFormRenderer(formData, {}, {})
}