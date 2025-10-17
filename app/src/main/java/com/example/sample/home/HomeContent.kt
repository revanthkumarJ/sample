package com.example.sample.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sample.advanced.navigateToAdvancedScreen
import com.example.sample.cards.navigateToCardsScreen
import com.example.sample.components.RButton
import com.example.sample.error_components.navigateToErrorScreen
import com.example.sample.loaders.navigateToLoaderScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Home") },
            )
        }
    ) { paddingValues ->

        val items = listOf(
            ListItem("Loaders") {
                navController.navigateToLoaderScreen()
            },
            ListItem("Empty Components") {
                navController.navigateToErrorScreen()
            },
            ListItem("Advanced Components") {
                navController.navigateToAdvancedScreen()
            },
            ListItem("Cards") {
                navController.navigateToCardsScreen()
            }
        )

        LazyColumn(
            Modifier.padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    text="Each button takes you to a set of components where each button takes you to the preview of component and button name is the component name after adding the library you can use that component",
                    modifier = Modifier.padding(8.dp)
                    )
            }

            items(items.size) { index ->
                RButton(text = items[index].text, onClick = items[index].onClick)
            }
        }
    }
}

data class ListItem(
    val text: String,
    val onClick: () -> Unit
)

