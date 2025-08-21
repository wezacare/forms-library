package com.wezacare.forms.app.components.complementary

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CallMade
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wezacare.forms.core.presentation.BorderGray
import com.wezacare.forms.core.presentation.ErrorDark
import com.wezacare.forms.core.presentation.SuccessDark

@Composable
fun FormTableItem(
    id: String,
    title: String,
    createdAt: String,
    onClick: (id: String) -> Unit,
    modifier: Modifier = Modifier,
    showDate: Boolean = false,
    sent: Boolean? =  null,
    onRetry: (id: String) -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick(id) }
            .padding(vertical = 12.dp, horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(0.70f)
        ){
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = createdAt,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodySmall
                )
                if(sent != null) {
                    Spacer(
                        modifier = Modifier.size(8.dp)
                    )
                    Row(
                        modifier = Modifier
                            .background(
                                if (sent == true) SuccessDark else ErrorDark,
                                RoundedCornerShape(100)
                            )
                            .padding(horizontal = 4.dp, vertical = 1.5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier.size(10.dp),
                            imageVector = if (sent == true) Icons.Default.Check
                            else Icons.Default.Close,
                            contentDescription = "",
                            tint = Color.White
                        )

                        Text(
                            modifier = Modifier.padding(start = 3.dp),
                            text = if (sent == true) "Sent" else "Retry",
                            fontSize = 9.sp,
                            color = Color.White
                        )
                    }
                }
            }

        }


        if(showDate && sent == false) {
            Row(
                modifier = Modifier
                    .border(0.7.dp, BorderGray, MaterialTheme.shapes.small)
                    .background(Color.White, MaterialTheme.shapes.small)
                    .clickable { onRetry(id) }
                    .padding(vertical = 6.dp, horizontal = 8.dp)
            ) {
                Icon(
                    modifier = Modifier.size(14.dp),
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "",
                    tint = Color.DarkGray
                )


                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = "Retry",
                    color = Color.DarkGray,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}