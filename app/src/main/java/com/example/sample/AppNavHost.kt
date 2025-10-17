package com.example.sample

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.sample.advanced.advancedScreensDestination
import com.example.sample.buttons.buttonGraph
import com.example.sample.cards.cardsScreenDestination
import com.example.sample.error_components.errorScreensDestination
import com.example.sample.home.HomeNavigation
import com.example.sample.home.homeDestination
import com.example.sample.loaders.loaderDestination
import com.example.sample.login.loginGraph
import com.example.sample.text_felds.textFieldsScreensDestination

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HomeNavigation) {

        homeDestination(navController)
        loaderDestination(navController)
        errorScreensDestination(navController)
        advancedScreensDestination(navController)
        cardsScreenDestination(navController)
        textFieldsScreensDestination(navController)
        loginGraph(navController::popBackStack)
        buttonGraph(navController::popBackStack)
    }
}