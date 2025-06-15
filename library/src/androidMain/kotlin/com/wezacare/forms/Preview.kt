package com.wezacare.forms

import android.graphics.Bitmap
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wezacare.forms.app.model.FormElement
import com.wezacare.forms.app.components.FormGroup
import com.wezacare.forms.app.components.FormGroupHeader
import com.wezacare.forms.app.components.FormImageInput
import com.wezacare.forms.app.components.FormTextInput
import com.wezacare.forms.app.components.FormVideoInput
import com.wezacare.forms.app.model.FormField


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
        modifier = Modifier.padding(16.dp)
    ) {
        val formData = remember { mutableStateMapOf<String, String>() }
        val errors = remember { mutableStateMapOf<String, String>() }

        FormGroupHeader(
            id = "header",
            title = "Nutritional and Diet Plan Form",
            description = "The Wezacare Education plan is designed for online and in-person " +
                    "classrooms and educational programs. We need a few more details to verify that you're" +
                    "a student or educator in an eligible school or course",
            pageTitle = "Page 1 of 1"
        ).Render(formData, { id, value  -> formData[id] = value }, errors)

    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewFormTextInput() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        val formData = remember { mutableStateMapOf<String, String>() }
        val errors = remember { mutableStateMapOf<String, String>() }

        FormTextInput(id="email", label = "What is your Email Address?", placeholder = "Your Email Address")
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
private fun PreviewForm() {
    FormScreen()
}

@Preview(showBackground = true)
@Composable
private fun PreviewMultiPageFormScreen() {
    MultiPageFormScreen()
}