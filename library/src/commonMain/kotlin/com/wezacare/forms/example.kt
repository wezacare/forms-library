package com.wezacare.forms

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.wezacare.forms.app.MultiPageFormRenderer
import com.wezacare.forms.app.model.data.FormSchema
import com.wezacare.forms.app.model.data.FormTheme
import com.wezacare.forms.app.model.data.PageModel
import com.wezacare.forms.app.model.data.QuestionModel


@Composable
fun MultiPageFormScreen() {

    val formData = FormSchema(
        id = "form-1",
        title = "Employee Onboarding",
        description = "A form to onboard new employees, collect personal and job-related information.",
        thumbnail = "https://picsum.photos/200/300?random=21",
        redirectUrl = "/app/forms/employee-onboarding/thank-you",
        theme = FormTheme(
            primaryColor = "#1a73e8",
            backgroundColor = "#ffffff",
            textColor = "#000000",
            headerImage = FormTheme.HeaderImage(url = "https://picsum.photos/600/100?random=1"),
        ),
        isVerticalScroll = true,
        createdAt = "2024-06-01T10:00:00Z",
        updatedAt = "2024-06-02T12:00:00Z",
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
                placeholder = "Joe Daniel",
                description = "Enter your first name.",
            ),
            QuestionModel(
                id = "q1-3",
                pageId = "p2-1",
                type = "short-text",
                label = "Department",
                required = true,
                placeholder = "Eating Department",
                description = "Enter your department.",
                isFirst = true,
                sectionBanner = "Section 2 of 2"
            )
        ),
        isPublished = false,
        isPublic = true,
        organisationId = "form-1",
        createdBy = "Samora Machel"
    )


    MultiPageFormRenderer(formData, {}, {}, {
        Text(
            text = "Samora"
        )
    })
}