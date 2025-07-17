package com.wezacare.forms

import android.graphics.Bitmap
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wezacare.forms.app.components.FormCheckBoxInput
import com.wezacare.forms.app.components.FormDropDown
import com.wezacare.forms.app.model.FormElement
import com.wezacare.forms.app.components.FormGroup
import com.wezacare.forms.app.components.FormGroupHeader
import com.wezacare.forms.app.components.FormImageInput
import com.wezacare.forms.app.components.FormLinkedDoc
import com.wezacare.forms.app.components.FormOptionInput
import com.wezacare.forms.app.components.FormTextInput
import com.wezacare.forms.app.components.FormVideoInput
import com.wezacare.forms.app.model.FormField
import com.wezacare.forms.core.presentation.DEFAULT_FORM_COLOR


//@Preview(showBackground = true)
//@Composable
//private fun PreviewFormGroup() {
//    Column(
//        modifier = Modifier.padding(16.dp)
//    ) {
//        FormGroup(
//            id = "",
//            label = "Demographic Information",
//            children = listOf(
//                FormTextInput(id = "", label = "What is your first name?", placeholder = "Your answer" ) as FormField<Any>
//            )
//        )
//    }
//}

@Preview(showBackground = true)
@Composable
private fun PreviewFormBanner() {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        val formData = remember { mutableStateMapOf<String, String>() }
        val errors = remember { mutableStateMapOf<String, String>() }

        FormGroupHeader(
            id = "header",
            title = "Nutritional and Diet Plan Form",
            description = "The Wezacare Education plan is designed for online and in-person " +
                    "classrooms and educational programs. We need a few more details to verify that you're" +
                    "a student or educator in an eligible school or course",
        ).Render(formData, { id, value  -> formData[id] = value }, errors)

    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewFormLinkedDoc() {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        val formData = remember { mutableStateMapOf<String, String>() }
        val errors = remember { mutableStateMapOf<String, String>() }

        FormLinkedDoc(
            id = "LinkedDocument",
            title = "Food Preference and Restriction",
            link = ""
        ).Render(formData, { id, value -> }, errors)
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewExposedDropDown() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        val formData = remember { mutableStateMapOf<String, String>() }
        val errors = remember { mutableStateMapOf<String, String>() }

        FormDropDown(
            id = "ExposedDropDown",
            label = "What is your prefered contact method?",
            subLabel = "Use the dropdown to pick the most reliable way for us to contact you",
            optionList = listOf("Samora", "Machel", "Amisi", "Kevin", "Adrian"),
            placeholder = "Select an option",
            required = true
        ).Render(formData, { id, value -> }, errors)
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewFormTextInput() {
    Column(
        modifier = Modifier
            .background(Color.Green.copy(alpha = 0.08f))
            .padding(16.dp)
    ) {
        val formData = remember { mutableStateMapOf<String, String>() }
        val errors = remember { mutableStateMapOf<String, String>() }

        FormTextInput(
            id="email",
            label = "What is your Email Address?",
            placeholder = "Your Email Address",
            description = "Please, use your educational email address " +
                    "that belongs to the domain of your educational " +
                    "institution. If you don’t have an education email, " +
                    "please explain.",
            pageTitle = "Page 2  of 3",
            showPageTitle = true,
            color = Color.Blue
        )
            .Render(formData, { id, value  -> formData[id] = value }, errors)
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewFormImageInput() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        val formData = remember { mutableStateMapOf<String, Any>() }
        val errors = remember { mutableStateMapOf<String, String>() }

        FormImageInput(id = "image", label = "Profile Picture", placeholder = "Select one image from the drive", required = true)
            .Render(formData, { id, value -> formData[id] = value as Any }, errors)

    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewFormVideoInput() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        val formData = remember { mutableStateMapOf<String, String>() }
        val errors = remember { mutableStateMapOf<String, String>() }

        FormVideoInput(id = "video", label = "Introduction Video", placeholder = "Select one video from the drive", required = true)
            .Render(formData, {id, value -> }, errors)
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewCheckBoxInput() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        val formData = remember { mutableStateMapOf<String, String>() }
        val errors = remember { mutableStateMapOf<String, String>() }

        FormCheckBoxInput(id = "checkbox", required = true, label = "Which of the following individuals reside in your household",
            subLabel = "(Select all that apply)", optionList = listOf("Parent(s)", "Siblings", "Other Relatives", "Guardian")
        ).Render(formData, {id, value -> }, errors)
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewOptionInput() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        val formData = remember { mutableStateMapOf<String, String>() }
        val errors = remember { mutableStateMapOf<String, String>() }

        FormOptionInput(
            id = "option",
            required = true,
            label = "On a scale from 1 to 5, how would you rate your current level of education",
            subLabel = "(1 being the lowest, 5 being the highest)",
            optionList = listOf("1", "2", "3", "4", "5")
        ).Render(formData, {id, value -> }, errors)
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun PreviewForm() {
//    FormScreen()
//}
//
@Preview(showBackground = true)
@Composable
private fun PreviewMultiPageFormScreen() {
    DEFAULT_FORM_COLOR = Color.Red
    MultiPageFormScreen()
}