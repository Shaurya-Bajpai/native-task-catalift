package com.example.native_task_catalift.bars

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        placeholder = { Text("Search", modifier = Modifier.padding(horizontal = 8.dp)) },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White,
            focusedBorderColor = Color.LightGray.copy(alpha = 0.2f),
            unfocusedBorderColor = Color.LightGray.copy(alpha = 0.2f),
            focusedLeadingIconColor = Color(0xFF000955),
            unfocusedLeadingIconColor = Color(0xFF000955),
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(50)),
    )
}
