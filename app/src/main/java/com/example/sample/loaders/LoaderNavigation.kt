package com.example.sample.loaders

import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object LoaderRouteButtons


fun NavController.navigateToLoaderScreen() {
    this.navigate(LoaderRouteButtons)
}

fun NavGraphBuilder.loaderDestination() {
    composable<LoaderRouteButtons> {
        Text("Hello")
    }
}