package com.wezacare.forms.app.components.complementary

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.wezacare.forms.app.model.ui.FormTableData
import com.wezacare.forms.core.presentation.BorderGray
import com.wezacare.forms.core.presentation.topBorder

data class CollapsableFormData(
    val id: String, 
    val title: String,
    val createdAt: String,
    val sent: Boolean? = null,
    val showDate: Boolean = false,
    val onRetry: (id: String) -> Unit = {},
    val onClick: (id: String) -> Unit = {}
)

@Composable
fun CollapsableForm(
    dateTitle: String,
    forms: List<CollapsableFormData>,
    onCollapsed: (Boolean) -> Unit,
    collapsed: Boolean = true,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {

        Text(
            text = dateTitle,
            fontWeight = FontWeight.ExtraBold,
            style = MaterialTheme.typography.bodyLarge
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onCollapsed(!collapsed) }
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .padding(end = 8.dp),
                imageVector =
                    if (!collapsed) Icons.Default.KeyboardArrowUp
                    else Icons.Default.KeyboardArrowDown,
                contentDescription = "",
                tint = Color.Gray
            )

            if(collapsed) {
                Text(
                    text = "${forms.size} Form${if(forms.size > 1) "s" else ""} Completed",
                    fontWeight = FontWeight.ExtraBold,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
        if(!collapsed) {
            Column(
                modifier = modifier
                    .border(0.7.dp, BorderGray, RoundedCornerShape(5.dp))
            ) {
                forms.forEachIndexed { index, form ->
                    FormTableItem(
                        modifier = Modifier.topBorder(
                            if(index == 0) 0.dp else 0.7.dp,
                            BorderGray
                        ),
                        id = form.id,
                        title = form.title,
                        createdAt = form.createdAt,
                        onClick = form.onClick,
                        onRetry = form.onRetry,
                        sent = form.sent,
                        showDate = form.showDate
                    )
                }
            }
        }

    }

}