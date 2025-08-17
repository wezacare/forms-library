package com.wezacare.forms.app.components.complementary

import androidx.compose.foundation.border
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.wezacare.forms.app.model.data.FormSchema
import com.wezacare.forms.app.model.ui.FormTableData
import com.wezacare.forms.core.presentation.BorderGray
import com.wezacare.forms.core.presentation.topBorder

@Composable
fun FormTable(
    forms: List<FormTableData>,
    onFormClicked: (id: String) -> Unit,
    borderColor: Color = BorderGray,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .border(0.7.dp, borderColor, RoundedCornerShape(5.dp))
    ) {
        itemsIndexed(forms) { index, form ->
            FormTableItem(
                modifier = Modifier.topBorder(
                    if(index == 0) 0.dp else 0.7.dp,
                    BorderGray
                ),
                id = form.id,
                title = form.title,
                createdAt = form.createdAt,
                onClick = onFormClicked
            )
        }

    }
}