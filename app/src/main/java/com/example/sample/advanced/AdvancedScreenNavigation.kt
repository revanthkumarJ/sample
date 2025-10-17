package com.example.sample.advanced

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.r_components.advanced.Step
import com.example.r_components.advanced.Stepper
import com.example.r_components.error_components.EmptyUi
import com.example.sample.components.ScaffoldContent
import com.example.sample.error_components.ErrorContentScreen
import com.example.sample.error_components.NoInternet
import com.example.sample.error_components.noInternet
import kotlinx.serialization.Serializable

@Serializable
data object AdvancedScreenNavigation


fun NavController.navigateToAdvancedScreen() {
    this.navigate(AdvancedScreenNavigation)
}

fun NavGraphBuilder.advancedScreensDestination(
    navController: NavController,
) {
    navigation<AdvancedScreenNavigation>(
        startDestination = AdvancedScreenRoute,
    ) {
        composable<AdvancedScreenRoute> {
            AdvancedScreen(
                onBackClick = navController::popBackStack,
                onStepperClick = {
                    navController.navigate(Stepper)
                },
            )
        }
        stepperUi(
            navController::popBackStack
        )

    }
}

@Serializable
data object AdvancedScreenRoute

@Serializable
data object Stepper

fun NavGraphBuilder.stepperUi(
    onBackClick: () -> Unit
) {

    composable<Stepper> {
        var currentIndex by remember {
            mutableIntStateOf(0)
        }
        val steps = listOf(
            Step("Details") {
                StepContent("Step 1: Details Content") { currentIndex++ }
            },
            Step("Terms") {
                StepContent("Step 2: Terms Content") { currentIndex++ }
            },
            Step("Charges") {
                StepContent("Step 3: Charges Content") { currentIndex++ }
            },
            Step("Schedule") {
                StepContent("Step 4: Schedule Content") { currentIndex++ }
            },
            Step("Preview") {
                StepContent("Step 5: Preview Content") { /* Final step */ }
            }
        )

        ScaffoldContent(
            "Stepper"
            ,onBackClick
        ){
            Stepper(
                steps = steps,
                currentIndex = currentIndex,
                onStepChange = {
                    currentIndex = it
                },
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}


@Composable
fun StepContent(text: String, onNextClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onNextClick) {
            Text("Next")
        }
    }
}