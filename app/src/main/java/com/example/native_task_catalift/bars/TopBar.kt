package com.example.native_task_catalift.bars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.native_task_catalift.R

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF000955))
            .padding(top = 16.dp)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Text("CATA", color = Color.White, fontWeight = FontWeight.Bold)
            Spacer(Modifier.width(2.dp))
            Column {
                Divider(thickness = 1.dp, color = Color.White, modifier = Modifier.width(35.dp))
                Text("LIFT", color = Color.White)
            }
        }

        Row {
            Icon(Icons.Default.AccountCircle, contentDescription = "Profile", tint = Color.White)
            Spacer(Modifier.width(12.dp))
            Icon(Icons.Default.Notifications, contentDescription = "Notification", tint = Color.White)
            Spacer(Modifier.width(12.dp))
            Icon(painter = painterResource(R.drawable.baseline_message_24), contentDescription = "Message", tint = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar()
}
