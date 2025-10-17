package com.example.sample.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.r_components.error_components.EmptyUi
import com.example.r_components.login.LoginPage
import com.example.sample.components.ScaffoldContent
import com.example.sample.error_components.EmptyUi
import kotlinx.serialization.Serializable

@Serializable
data object LoginNavigation


fun NavController.navigateToLoginScreen() {
    this.navigate(LoginNavigation)
}

fun NavGraphBuilder.loginGraph(
    onBackClick: () -> Unit
) {
    composable<LoginNavigation> {
        var userName by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var isPasswordVisible by remember { mutableStateOf(false) }
        ScaffoldContent(
            "LoginPage"
            ,onBackClick
        ){
            LoginPage(
                logo = {},
                userName = userName,
                password = password,
                onUserNameChanged ={
                    userName=it
                },
                onPasswordChanged = {
                    password=it
                },
                userNameError = if(userName.isEmpty()) "UserName should not be empty" else null,
                passwordError = if(password.isEmpty()) "Password should not be empty" else null,
                isPasswordVisible = isPasswordVisible,
                onPasswordVisibilityChange = {
                    isPasswordVisible=it
                },
                onLoginClick = {

                }
            )
        }
    }
}
