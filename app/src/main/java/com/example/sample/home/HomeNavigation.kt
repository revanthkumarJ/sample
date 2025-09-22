package com.example.sample.home

import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable


@Serializable
data object HomeNavigation


fun NavController.navigateToHomeScreen() {
    this.navigate(HomeNavigation)
}

fun NavGraphBuilder.homeDestination(
    navController: NavController
) {
    composable<HomeNavigation> {
        HomeContent(
            navController
        )
    }
}