package com.example.sample.loaders

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sample.components.RButton
import com.example.sample.components.ScaffoldContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoaderButtonScreen(
    onBackClick: () -> Unit,
    onFullProgressIndicatorClick: () -> Unit,
    onFullProgressIndicatorOverlayClick: () -> Unit,
    onLoadingDialogClick: () -> Unit,
    onFullWidthLoaderClick: () -> Unit,
) {
    ScaffoldContent("Loader Button Screen",onBackClick){
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RButton(
                text = "FullProgressIndicator",
                onClick = onFullProgressIndicatorClick
            )
            RButton(
                text = "FullProgressIndicatorOverlay",
                onClick = onFullProgressIndicatorOverlayClick
            )
            RButton(
                text = "LoadingDialog",
                onClick = onLoadingDialogClick
            )
            RButton(
                text = "FullWidthLoader",
                onClick = onFullWidthLoaderClick
            )
        }
    }
}