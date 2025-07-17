package com.wezacare.forms.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.wezacare.forms.core.presentation.DEFAULT_FORM_COLOR
import com.wezacare.forms.core.presentation.FormBorderGray
import com.wezacare.forms.core.presentation.FormErrorRed
import com.wezacare.forms.core.presentation.formVioletDark

@Composable
fun FormItemContainer(
    modifier: Modifier = Modifier,
    isValid: Boolean = true,
    showPageTitle: Boolean = false,
    page: String? = null,
    color: Color = DEFAULT_FORM_COLOR,
    content: @Composable ColumnScope.() -> Unit
) {
    val corner = 8.dp
    Column(
        modifier = Modifier
    ) {
        if(!page.isNullOrBlank() && showPageTitle) {
            Box(
                modifier = Modifier
                    .background(
                        color,
                        RoundedCornerShape(topStart = corner, topEnd = corner),
                    )
                    .width(100.dp)
                    .height(30.dp),
                contentAlignment = Alignment.Center

            ){
                Text(
                    text = page,
                    color = Color.LightGray
                )
            }
        }
        Column (
            modifier = Modifier
                .background(
                    color,
                    RoundedCornerShape(
                        topEnd = corner,
                        topStart = if(page.isNullOrBlank() && !showPageTitle) corner
                        else 0.dp,
                        bottomEnd = corner,
                        bottomStart = corner
                    )

                )

        ) {
            Column(
                modifier = modifier
                    .background(Color.White, MaterialTheme.shapes.small)
                    .clip(MaterialTheme.shapes.small)
                    .border(
                        0.4.dp,
                        if(isValid) FormBorderGray else FormErrorRed,
                        MaterialTheme.shapes.small
                    )
                    .padding(vertical = 14.dp, horizontal = 16.dp)
                    .fillMaxWidth()
            ) {
                content()
            }

        }

    }

}