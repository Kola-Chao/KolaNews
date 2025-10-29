package com.kola.news.feature.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kola.news.core.designsystem.theme.KolaNewsTheme
import com.kola.news.core.ui.navigation.KolaNewsNavigationDestination

object ProfileDestination : KolaNewsNavigationDestination {
    override val route: String = "profile"
    override val destination: String = "profile"
}

@Composable
fun ProfileRoute(modifier: Modifier = Modifier) {
    ProfileScreen(modifier = modifier)
}

@Composable
internal fun ProfileScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Your Profile",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
        )
        Text(
            modifier = Modifier.padding(top = 12.dp),
            text = "Manage saved topics and reading history here.",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview
private fun ProfileScreenPreview() {
    KolaNewsTheme {
        ProfileScreen()
    }
}
