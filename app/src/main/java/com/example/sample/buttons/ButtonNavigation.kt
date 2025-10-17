package com.example.sample.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.r_components.button.RevButton
import com.example.r_components.button.RevOutlinedButton
import com.example.r_components.button.RevTextButton
import com.example.sample.components.ScaffoldContent
import kotlinx.serialization.Serializable

@Serializable
data object ButtonNavigation


fun NavController.navigateToButtonScreen() {
    this.navigate(ButtonNavigation)
}

fun NavGraphBuilder.buttonGraph(
    onBackClick: () -> Unit
) {
    composable<ButtonNavigation> {
        ScaffoldContent(
            "ButtonPage"
            ,onBackClick
        ){
            Column(
                Modifier.fillMaxSize().padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                RevButton(
                    onClick = { /* Handle click */ },
                    text = { Text("RevButton") },
                    modifier = Modifier.fillMaxWidth()
                )
                RevOutlinedButton(
                    onClick = { /* Handle click */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("RevOutlinedButton")
                }
                RevTextButton(
                    text = { Text("RevTextButton") },
                    onClick = { /* Navigate to reset */ }
                )
                RevButton(
                    onClick = { /* Won’t trigger */ },
                    text = { Text("RevButton") },
                )
            }
        }
    }
}
