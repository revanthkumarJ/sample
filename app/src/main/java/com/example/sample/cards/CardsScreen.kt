package com.example.sample.cards

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.r_components.cards.RevCard
import com.example.r_components.cards.RevCustomCard
import com.example.r_components.cards.CardVariant
import com.example.r_components.cards.RevExploreCard
import com.example.r_components.cards.RevUploadStateCard
import com.example.r_components.cards.RevUploadedStateCard
import com.example.sample.components.ScaffoldContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardsScreen(
    onBackClick: () -> Unit,
) {
    ScaffoldContent(
        title = "Cards Showcase",
        onBackClick = onBackClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // 1️⃣ Basic Card
            RevCard {
                Text("This is a simple RevCard")
            }

            // 2️⃣ Filled Custom Card
            RevCustomCard(
                variant = CardVariant.FILLED,
                onClick = { /* handle click */ }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Filled Card Example")
                }
            }

            // 3️⃣ Elevated Card
            RevCustomCard(
                variant = CardVariant.ELEVATED,
                onClick = { /* handle click */ }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Elevated Card Example")
                }
            }

            // 4️⃣ Outlined Card
            RevCustomCard(
                variant = CardVariant.OUTLINED,
                onClick = { /* handle click */ }
            ) {
                Text(
                    text = "Outlined Card Example",
                    modifier = Modifier.padding(16.dp)
                )
            }

            // 5️⃣ Explore Card
            RevExploreCard(
                text = "Personal Loan",
                icon = Icons.Default.Refresh,
                onClick = { /* navigate or action */ }
            )

            // 6️⃣ Upload Card
            RevUploadStateCard(
                text = "Upload Your ID",
                icon = Icons.Default.Refresh,
                onClick = { /* trigger upload */ }
            )

            // 7️⃣ Uploaded State Card
            RevUploadedStateCard(
                label = "Profile Photo",
                icon = Icons.Default.Refresh,
                fileName = "profile_photo.png",
                fileSize = "256 KB",
                onRemoveClick = { /* remove file */ },
                onViewClick = { /* open file */ },
                onSelectNewClick = { /* select new file */ },
                removeText = "Remove File",
                selectText = "Select New",
                viewText = "View File",
            )
        }
    }
}
