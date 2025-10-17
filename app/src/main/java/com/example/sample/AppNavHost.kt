package com.example.sample

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.sample.error_components.errorScreensDestination
import com.example.sample.home.HomeNavigation
import com.example.sample.home.homeDestination
import com.example.sample.loaders.loaderDestination

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HomeNavigation) {

        homeDestination(navController)
        loaderDestination(navController)
        errorScreensDestination(navController)
    }
}