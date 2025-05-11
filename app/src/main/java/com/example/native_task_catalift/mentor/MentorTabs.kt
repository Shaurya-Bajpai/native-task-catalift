package com.example.native_task_catalift.mentor

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MentorTabs() {
    val selectedTab = remember { mutableStateOf("Explore") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFEFEFF3), shape = RoundedCornerShape(50)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        listOf("My Mentors", "Explore").forEach { tab ->
            val isSelected = tab == selectedTab.value
            Text(
                text = tab,
                modifier = Modifier
                    .weight(1f)
                    .clickable { selectedTab.value = tab }
                    .background(
                        if (isSelected) Color(0xFF000955) else Color.Transparent,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(vertical = 8.dp),
                textAlign = TextAlign.Center,
                color = if (isSelected) Color.White else Color.Gray,
                fontSize = 14.sp
            )
        }
    }
}
