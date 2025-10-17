package com.example.sample.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.r_components.button.RevButton

@Composable
fun RButton(
    text: String,
    onClick: () -> Unit,
) {
    RevButton(
        onClick = onClick,
        text = {
            Text(text)
        },
        modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth()
    )
}