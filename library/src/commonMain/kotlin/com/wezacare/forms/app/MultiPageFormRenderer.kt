package com.wezacare.forms.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import com.wezacare.forms.app.model.FormUIData
import com.wezacare.forms.app.model.FormField
import com.wezacare.forms.app.model.FormPage
import com.wezacare.forms.app.pagers.HorizontalFormPager
import com.wezacare.forms.app.pagers.VerticalFormPager
import com.wezacare.forms.app.model.MultiPageForm
import com.wezacare.forms.app.model.NavigationMode
import com.wezacare.forms.app.tranformer.QuestionFactory

@Composable
fun MultiPageFormRenderer(
    formData: FormUIData,
    onSubmit: (Map<String, Any>) -> Unit,
    onBackClick: () -> Unit,
) {

    val values: MutableMap<String, Any> = remember { mutableStateMapOf() }
    val errors: MutableMap<String, String?> = remember { mutableStateMapOf() }
    val pages: MutableList<FormPage> = mutableListOf()
    val components : MutableList<FormField<Any>> = mutableListOf()



    formData.questions.forEach { question ->
        val formTransformer = QuestionFactory.createFormComponent(question, formData.theme)
        formTransformer?.let { transformer ->
            components.add(transformer.transform())
        }
    }

    formData.pages.forEach { page ->
        val formPage = FormPage(
            id = page.id,
            formId = page.formId,
            title = page.title,
            order = page.order,
            page = page.order,
            formTheme = formData.theme,
            components = components.filter { component ->
                component.pageId == page.id
            },
        )
        pages.add(formPage)
    }


    val multiPageForm = MultiPageForm(
        pages = pages,
        formTitle = formData.title,
        formDescription = formData.description,
        navigationMode = if(formData.isVerticalScroll) NavigationMode.VERTICAL
            else NavigationMode.HORIZONTAL,
        formTheme = formData.theme
    )

    when (multiPageForm.navigationMode) {
        NavigationMode.HORIZONTAL -> HorizontalFormPager(multiPageForm, { onSubmit(values) }, onBackClick, values, errors)
        NavigationMode.VERTICAL -> VerticalFormPager(multiPageForm, { onSubmit(values) }, onBackClick, values, errors)
    }

}