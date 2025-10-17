package com.example.sample.advanced

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sample.components.RButton
import com.example.sample.components.ScaffoldContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdvancedScreen(
    onBackClick: () -> Unit,
    onStepperClick: () -> Unit,
) {
    ScaffoldContent("Advanced Content Screen",onBackClick){
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RButton(
                text = "Stepper",
                onClick = onStepperClick
            )
        }
    }
}