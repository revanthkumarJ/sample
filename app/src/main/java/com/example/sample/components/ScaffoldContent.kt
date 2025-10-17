package com.example.sample.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldContent(
    title: String="",
    onBackClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Scaffold(
    topBar = {
        TopAppBar(
            title = { Text(title) },
            navigationIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Menu",
                    modifier = Modifier.clickable(onClick = onBackClick)
                )
            }
        )
    },
    ){ padding->
        Box(Modifier.padding(padding)){
            content()
        }

    }
}