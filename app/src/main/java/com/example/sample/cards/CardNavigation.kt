package com.example.sample.cards

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object CardsScreenRoute

fun NavController.navigateToCardsScreen() {
    this.navigate(CardsScreenRoute)
}

fun NavGraphBuilder.cardsScreenDestination(
    navController: NavController,
) {
    composable<CardsScreenRoute> {
        CardsScreen(
            onBackClick = navController::popBackStack
        )
    }
}
