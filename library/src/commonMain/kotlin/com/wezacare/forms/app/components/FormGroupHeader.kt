package com.wezacare.forms.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.wezacare.forms.app.model.FormDecorator
import com.wezacare.forms.app.model.FormElement
import com.wezacare.forms.app.model.FormMargin
import com.wezacare.forms.core.presentation.DEFAULT_FORM_COLOR
import com.wezacare.forms.core.presentation.FormBorderGray
import com.wezacare.forms.core.presentation.FormErrorRed
import com.wezacare.forms.core.presentation.formVioletDark

data class FormGroupHeader (
    override val id: String,
    val title: String,
    val description: String,
    val pageTitle: String? = null,
    override val margin: FormMargin = FormMargin(4.dp, 4.dp),
): FormDecorator {

    @Composable
    override fun Render(
        values: Map<String, Any>,
        onValueChange: (String, String) -> Unit,
        errors: Map<String, String?>
    ) {
        val corner = 8.dp

        Spacer(modifier = Modifier.size(margin.top))
        Column {
            if(!pageTitle.isNullOrBlank()) {
                Box(
                    modifier = Modifier
                        .background(
                            DEFAULT_FORM_COLOR,
                            RoundedCornerShape(topStart = corner,
                                topEnd = corner),
                            )
                        .width(100.dp)
                        .height(30.dp),
                    contentAlignment = Alignment.Center

                ){
                    Text(
                        text = pageTitle,
                        color = Color.LightGray
                    )
                }
            }

            Column(
                modifier = Modifier
                    .background(
                        DEFAULT_FORM_COLOR,
                        RoundedCornerShape(
                            topEnd = corner,
                            topStart = if(pageTitle.isNullOrBlank()) corner else 0.dp,
                            bottomEnd = corner,
                            bottomStart = corner
                        )
                    )
            ) {
                Column(
                    modifier = Modifier
                        .background(Color.White, MaterialTheme.shapes.small)
                        .clip(MaterialTheme.shapes.small)
                        .border(1.dp, FormBorderGray, MaterialTheme.shapes.small)
                        .fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .height(12.dp)
                            .fillMaxWidth()
                            .background(DEFAULT_FORM_COLOR.copy(alpha = 0.4f))
                    )

                    Text(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(title)
                            }


                            withStyle(
                                style = SpanStyle(
                                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.DarkGray
                                )
                            ) {
                                append("\n\n")
                                append(description)
                            }
                        }
                    )
                }
            }

//            Text(
//                modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
//                text = " * Indicates required question",
//                color = FormErrorRed
//            )

        }
        Spacer(modifier = Modifier.size(margin.bottom))
    }
}