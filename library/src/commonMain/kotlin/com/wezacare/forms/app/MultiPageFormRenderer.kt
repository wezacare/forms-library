package com.wezacare.forms.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wezacare.forms.app.model.data.FormSchema
import com.wezacare.forms.app.model.ui.FormField
import com.wezacare.forms.app.model.ui.FormPage
import com.wezacare.forms.app.pagers.HorizontalFormPager
import com.wezacare.forms.app.pagers.VerticalFormPager
import com.wezacare.forms.app.model.ui.MultiPageForm
import com.wezacare.forms.app.model.ui.NavigationMode
import com.wezacare.forms.app.tranformer.QuestionFactory
import com.wezacare.forms.core.presentation.DEFAULT_FORM_COLOR

@Composable
fun MultiPageFormRenderer(
    formData: FormSchema,
    onSubmit: (Map<String, Any>) -> Unit,
    onBackClick: () -> Unit,
    values: MutableMap<String, Any> = remember { mutableStateMapOf() },
    errors: MutableMap<String, String?> = remember { mutableStateMapOf() },
    footer: @Composable ColumnScope.() -> Unit,
) {
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
            order = page.order,
            page = page.order,
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



    Column(
        modifier = Modifier
            .background((formData.theme?._primaryColor ?: DEFAULT_FORM_COLOR).copy(alpha = 0.07f))
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Text(
            text = "${values.map { it.value }}"
        )

        when (multiPageForm.navigationMode) {
            NavigationMode.HORIZONTAL -> HorizontalFormPager(multiPageForm, { onSubmit(values) }, onBackClick, values, errors)
            NavigationMode.VERTICAL -> VerticalFormPager(multiPageForm, { onSubmit(values) }, onBackClick, values, errors)
        }

        footer()
    }

}