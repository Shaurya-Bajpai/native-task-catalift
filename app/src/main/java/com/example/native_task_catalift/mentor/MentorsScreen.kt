package com.example.native_task_catalift.mentor

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.native_task_catalift.R
import com.example.native_task_catalift.bars.SearchBar
import com.example.native_task_catalift.bars.TopBar
import kotlinx.coroutines.launch

@Composable
fun MentorsScreen() {
    val pagerState = rememberPagerState(pageCount = { 3 }, initialPage = 1)
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = { TopBar() },
        bottomBar = {
            NavigationBar(containerColor = Color(0xFF000955)) {
                listOf("Home", "Explore Mentors", "Courses").forEachIndexed { index, label ->
                    NavigationBarItem(
                        icon = {
                            when (index) {
                                0 -> Icon(Icons.Default.Home, contentDescription = "Home")
                                1 -> Icon(Icons.Default.Search, contentDescription = "Explore Mentors")
                                2 -> Icon(painterResource(R.drawable.baseline_menu_book_24), contentDescription = "Courses")
                            }
                        },
                        selected = pagerState.currentPage == index,
                        onClick = {
                            coroutineScope.launch { pagerState.animateScrollToPage(index) }
                        },
                        label = { Text(label) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.White,
                            unselectedIconColor = Color.DarkGray,
                            indicatorColor = Color.Transparent,
                            disabledTextColor = Color.Gray,
                            selectedTextColor = Color.White
                        )
                    )
                }
            }
        },
        containerColor = Color(0xFFF9F9F9)
    ) { innerPadding ->
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) { page ->
            when (page) {
                0 -> {
                    // Home Screen Content
                    Column(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        Spacer(Modifier.height(16.dp))
                        Text("Home Screen", style = MaterialTheme.typography.headlineSmall)
                    }
                }
                1 -> {
                    // Explore Mentors Screen Content
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .verticalScroll(rememberScrollState())
                    ) {
                        Spacer(Modifier.height(16.dp))
                        Text("Mentors", style = MaterialTheme.typography.headlineSmall)
                        Spacer(Modifier.height(16.dp))
                        MentorTabs()
                        Spacer(Modifier.height(12.dp))
                        SearchBar()
                        Spacer(Modifier.height(16.dp))
                        repeat(3) {
                            MentorCard(
                                name = "Gaurav Samant",
                                sector = "IT Sector",
                                rating = 4.9f,
                                years = 4,
                                field = "Business Administration",
                                reviews = 175,
                                description = "Strategy Manager @CEO Office | Ex-eBay & L&T | MDI Gurgaon . ESCP Europe | 32+ National Case Comps Podiums",
                                compatibility = if (it == 0) 98 else if (it == 1) 82 else 76
                            )
                            Spacer(Modifier.height(16.dp))
                        }
                    }
                }
                2 -> {
                    // Courses Screen Content
                    Column(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        Spacer(Modifier.height(16.dp))
                        Text("Courses Screen", style = MaterialTheme.typography.headlineSmall)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MentorScreenPreview() {
    MentorsScreen()
}

