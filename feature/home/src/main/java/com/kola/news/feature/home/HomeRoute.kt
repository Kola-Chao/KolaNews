package com.kola.news.feature.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kola.news.core.designsystem.theme.KolaNewsTheme
import com.kola.news.core.ui.navigation.KolaNewsNavigationDestination

object HomeDestination : KolaNewsNavigationDestination {
    override val route: String = "home"
    override val destination: String = "home"
}

@Composable
fun HomeRoute(modifier: Modifier = Modifier) {
    HomeScreen(modifier = modifier){

    }
}

@Composable
internal fun HomeScreen(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Welcome to KolaNews",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier.padding(top = 12.dp),
            text = "Catch up with curated stories on your home feed.",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
        )

        Text(
            modifier = Modifier
                .padding(top = 12.dp)
                .clickable(onClick = onClick),
            text = "AAAA",
            textAlign = TextAlign.Center,
            color = Color.Red,
            style = MaterialTheme.typography.bodyLarge,
        )

    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    KolaNewsTheme {
        HomeScreen(){

        }
    }
}
