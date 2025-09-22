package com.example.sample.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun RButton(
    text: String,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        content = {
            Text(text)
        }
    )
}