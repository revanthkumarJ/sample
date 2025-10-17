package com.example.sample.loaders

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.r_components.loaders.FullProgressIndicator
import com.example.r_components.loaders.FullProgressIndicatorOverlay
import com.example.r_components.loaders.FullWidthLoader
import com.example.r_components.loaders.LoadingDialog
import com.example.sample.components.ScaffoldContent
import com.example.sample.home.HomeContent
import com.example.sample.home.HomeNavigation
import kotlinx.serialization.Serializable

@Serializable
data object LoaderRouteButtons


fun NavController.navigateToLoaderScreen() {
    this.navigate(LoaderRouteButtons)
}

fun NavGraphBuilder.loaderDestination(
    navController: NavController,
) {
    navigation<LoaderRouteButtons>(
        startDestination = LoaderButtons,
    ) {
        composable<LoaderButtons> {
            LoaderButtonScreen(
                onFullProgressIndicatorClick = {
                    navController.navigate(FullProgressIndicator)
                },
                onFullProgressIndicatorOverlayClick = {
                    navController.navigate(FullProgressIndicatorOverLay)
                },
                onLoadingDialogClick = {
                    navController.navigate(LoadingDialog)
                },
                onFullWidthLoaderClick = {
                    navController.navigate(FullWidthLoader)
                },
                onBackClick = navController::popBackStack
            )
        }
        fullProgressIndicator(
            navController::popBackStack
        )
        fullProgressIndicatorOverLay(
            navController::popBackStack
        )
        loadingDialog(
            navController::popBackStack
        )
        fullWidthLoader(
            navController::popBackStack
        )
    }
}

@Serializable
data object LoaderButtons

@Serializable
data object FullProgressIndicator

fun NavGraphBuilder.fullProgressIndicator(
    onBackClick: () -> Unit
) {
    composable<FullProgressIndicator> {
        ScaffoldContent(
            "FullProgressIndicator"
            ,onBackClick
        ){
            FullProgressIndicator()
        }
    }
}

@Serializable
data object FullProgressIndicatorOverLay

fun NavGraphBuilder.fullProgressIndicatorOverLay(
    onBackClick: () -> Unit
) {
    composable<FullProgressIndicatorOverLay> {
        ScaffoldContent(
            "FullProgressIndicatorOverLay"
            ,onBackClick
        ) {
            Box(Modifier.fillMaxWidth()){
                Column(
                    Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text("Hello")
                    Text("Thank you")
                    Text("For Showing interest in our Library")
                    Text("Hope you will love this")
                }
                FullProgressIndicatorOverlay()
            }
        }

    }
}

@Serializable
data object LoadingDialog

fun NavGraphBuilder.loadingDialog(
    onBackClick: () -> Unit
) {
    composable<LoadingDialog> {
        ScaffoldContent("LoadingDialog",onBackClick) {
            LoadingDialog()
        }
    }
}

@Serializable
data object FullWidthLoader

fun NavGraphBuilder.fullWidthLoader(
    onBackClick: () -> Unit,
) {
    composable<FullWidthLoader> {
        ScaffoldContent("FullWidthLoader",onBackClick) {
            FullWidthLoader()
        }
    }
}
