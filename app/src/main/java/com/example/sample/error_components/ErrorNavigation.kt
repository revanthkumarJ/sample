package com.example.sample.error_components

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.r_components.error_components.EmptyUi
import com.example.r_components.error_components.NoInternet
import com.example.r_components.loaders.FullProgressIndicator
import com.example.sample.components.ScaffoldContent
import com.example.sample.loaders.FullProgressIndicator
import com.example.sample.loaders.FullProgressIndicatorOverLay
import com.example.sample.loaders.FullWidthLoader
import com.example.sample.loaders.LoaderButtonScreen
import com.example.sample.loaders.LoaderButtons
import com.example.sample.loaders.LoadingDialog
import com.example.sample.loaders.fullProgressIndicator
import com.example.sample.loaders.fullProgressIndicatorOverLay
import com.example.sample.loaders.fullWidthLoader
import com.example.sample.loaders.loadingDialog
import kotlinx.serialization.Serializable

@Serializable
data object ErrorRouteButtons


fun NavController.navigateToErrorScreen() {
    this.navigate(ErrorRouteButtons)
}

fun NavGraphBuilder.errorScreensDestination(
    navController: NavController,
) {
    navigation<ErrorRouteButtons>(
        startDestination = ErrorScreenRoute,
    ) {
        composable<ErrorScreenRoute> {
            ErrorContentScreen(
                onBackClick = navController::popBackStack,
                onEmptyUiClick = {
                    navController.navigate(EmptyUi)
                },
                onNoInternetClick = {
                    navController.navigate(NoInternet)
                },
            )
        }
        emptyUi(
            navController::popBackStack
        )
        noInternet(
            navController::popBackStack
        )
    }
}

@Serializable
data object ErrorScreenRoute

@Serializable
data object EmptyUi

fun NavGraphBuilder.emptyUi(
    onBackClick: () -> Unit
) {
    composable<EmptyUi> {
        ScaffoldContent(
            "EmptyUi"
            ,onBackClick
        ){
            EmptyUi(
                text = "This information is empty"
            )
        }
    }
}

@Serializable
data object NoInternet

fun NavGraphBuilder.noInternet(
    onBackClick: () -> Unit
) {
    composable<NoInternet> {
        ScaffoldContent(
            "EmptyUi"
            ,onBackClick
        ){
            NoInternet()
        }
    }
}