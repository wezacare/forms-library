package com.wezacare.forms.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.wezacare.forms.app.FormField
import com.wezacare.forms.app.FormState
import com.wezacare.forms.core.presentation.FormBorderGray
import com.wezacare.forms.core.presentation.FormErrorRed

@Composable
fun FormBanner(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    color: Color = Color.Blue
) {
    Column {
        Column(
            modifier = modifier
                .background(Color.White, MaterialTheme.shapes.large)
                .clip(MaterialTheme.shapes.large)
                .border(1.dp, FormBorderGray, MaterialTheme.shapes.large)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .background(color.copy(0.2f))
                    .fillMaxWidth()
                    .size(15.dp)
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
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
                            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                        )
                    ) {
                        append("\n\n")
                        append(description)
                    }
                }
            )
        }

        Text(
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 8.dp),
            text = " * Indicates required question",
            color = FormErrorRed
        )

    }
}


@Composable
fun BannerComposable(
    field: FormField.Banner,
) {
    FormBanner(
        title = field.title,
        description = field.description,
        color = Color.Blue
    )
}
