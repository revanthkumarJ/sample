package com.example.sample.text_felds

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.r_components.error_components.EmptyUi
import com.example.r_components.error_components.NoInternet
import com.example.r_components.text_fields.RevOtpTextField
import com.example.r_components.text_fields.RevOutlinedTextField
import com.example.r_components.text_fields.RevPasswordField
import com.example.r_components.text_fields.RevTextField
import com.example.r_components.text_fields.RevTextFieldConfig
import com.example.sample.components.ScaffoldContent
import com.example.sample.error_components.ErrorContentScreen
import kotlinx.serialization.Serializable

@Serializable
data object TextFieldNavigation


fun NavController.navigateToTextFieldsScreen() {
    this.navigate(TextFieldNavigation)
}

fun NavGraphBuilder.textFieldsScreensDestination(
    navController: NavController,
) {
    navigation<TextFieldNavigation>(
        startDestination = TextFieldScreenRoute,
    ) {
        composable<TextFieldScreenRoute> {
            TextFieldScreen(
                onBackClick = navController::popBackStack,
                onRevOtpTextFieldClick = {
                    navController.navigate(OTP)
                },
                onRevPasswordFieldClick = {
                    navController.navigate(PasswordRoute)
                },
                onTextFieldsClick = {
                    navController.navigate(TextFieldsRoute)
                }
            )
        }
        passwordUi(
            navController::popBackStack
        )
        otp(
            navController::popBackStack
        )
        textFields(
            navController::popBackStack
        )

    }
}

@Serializable
data object TextFieldScreenRoute

@Serializable
data object PasswordRoute

fun NavGraphBuilder.passwordUi(
    onBackClick: () -> Unit
) {
    composable<PasswordRoute> {
        var value by remember { mutableStateOf("") }
        var showPassword by remember { mutableStateOf(false) }
        ScaffoldContent(
            "RevPasswordField"
            ,onBackClick
        ){
                RevPasswordField(
                    label = "Label",
                    value = value,
                    onValueChange = {
                        value = it
                    },
                    showPassword = showPassword,
                    hint = "Hint",
                    showPasswordChange = {
                        showPassword = it
                    },
                    modifier = Modifier.padding(8.dp)
                )

        }
    }
}

@Serializable
data object OTP

fun NavGraphBuilder.otp(
    onBackClick: () -> Unit
) {
    composable<OTP> {
        ScaffoldContent(
            "RevOtpTextField"
            ,onBackClick
        ){
            RevOtpTextField(
                onOtpTextCorrectlyEntered = {},
                realOtp = "1234",
                otpCount = 4,
            )
        }
    }
}

@Serializable
data object TextFieldsRoute


fun NavGraphBuilder.textFields(
    onBackClick: () -> Unit
) {
    composable<TextFieldsRoute> {
        ScaffoldContent(
            title = "TextFields",
            onBackClick = onBackClick
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                var outlinedText by remember { mutableStateOf("") }
                var normalText by remember { mutableStateOf("") }

                // 🟢 RevOutlinedTextField Example
                RevOutlinedTextField(
                    value = outlinedText,
                    onValueChange = { outlinedText = it },
                    label = "RevOutlinedTextField",
                    config = RevTextFieldConfig(
                        showClearIcon = true,
                        errorText = if (outlinedText.length > 10) "Too long!" else null
                    ),
                )

                Spacer(modifier = Modifier.height(20.dp))

                // 🟣 RevTextField Example
                RevTextField(
                    value = normalText,
                    onValueChange = { normalText = it },
                    label = "RevTextField",
                    config = RevTextFieldConfig(
                        showClearIcon = true,
                        errorText = if (normalText.isEmpty()) "Cannot be empty!" else null
                    ),
                )
            }
        }
    }
}
