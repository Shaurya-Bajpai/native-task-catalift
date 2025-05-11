package com.example.native_task_catalift.mentor

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.native_task_catalift.R
import com.example.native_task_catalift.ui.theme.ItColor
import com.example.native_task_catalift.ui.theme.StarColor

@Composable
fun MentorCard(
    name: String,
    sector: String,
    rating: Float,
    years: Int,
    field: String,
    reviews: Int,
    description: String,
    compatibility: Int
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .fillMaxHeight(),
                    contentAlignment = Alignment.TopStart
                ) {
                    Image(
                        painter = painterResource(R.drawable.avatar),
                        contentDescription = null,
                        modifier = Modifier
                            .size(56.dp)
                            .clip(CircleShape)
                    )
                }
                Spacer(Modifier.width(12.dp))
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(painter = painterResource(R.drawable.baseline_star_outline_24), contentDescription = "Rating", tint = StarColor)
                        Text("$rating  ", fontWeight = FontWeight.SemiBold, fontSize = 14.sp, color = StarColor)

                        Box(
                            modifier = Modifier
                                .border(0.7.dp, ItColor, RoundedCornerShape(50))
                                .padding(horizontal = 12.dp, vertical = 2.dp)
                        ) {
                            Text(sector, fontSize = 13.sp, color = ItColor)
                        }
                    }

                    Spacer(Modifier.height(4.dp))

                    Text(name, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.Black)

                    Spacer(Modifier.height(4.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(painter = painterResource(R.drawable.baseline_access_alarm_24), contentDescription = null, modifier = Modifier.size(16.dp), tint = Color.Blue)
                        Spacer(Modifier.width(4.dp))
                        Text("$years years", color = Color.Blue, fontWeight = FontWeight.SemiBold, fontSize = 13.sp)

                        Spacer(Modifier.width(16.dp))

                        Icon(painter = painterResource(R.drawable.baseline_business_center_24), contentDescription = null, modifier = Modifier.size(16.dp), tint = Color.Blue)
                        Spacer(Modifier.width(4.dp))
                        Text(field, color = Color.Blue, fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(painter = painterResource(R.drawable.baseline_message_24), contentDescription = null, modifier = Modifier.size(16.dp), tint = Color.Blue)
                        Spacer(Modifier.width(4.dp))
                        Text("$reviews Reviews", color = Color.Blue, fontWeight = FontWeight.Medium, fontSize = 13.sp)
                    }

                    Spacer(Modifier.height(6.dp))
                    Text(description, color = Color.Gray, fontSize = 13.sp)

                    Spacer(Modifier.height(12.dp))
                    Row {
                        Text(
                            "$compatibility% ",
                            color = if (compatibility > 90) Color(0xFF3C873A) else Color(0xFFAC892B),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp
                        )
                        Text(
                            "compatibility",
                            color = if (compatibility > 90) Color(0xFF3C873A) else Color(0xFFAC892B),
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}
