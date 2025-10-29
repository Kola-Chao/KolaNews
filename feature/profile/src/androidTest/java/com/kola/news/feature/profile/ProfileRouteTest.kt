package com.kola.news.feature.profile

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kola.news.core.designsystem.theme.KolaNewsTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProfileRouteTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun profileRoute_showsProfileScreenContent() {
        composeTestRule.setContent {
            KolaNewsTheme {
                ProfileRoute()
            }
        }

        composeTestRule.onNodeWithText("Your Profile").assertIsDisplayed()
        composeTestRule
            .onNodeWithText("Manage saved topics and reading history here.")
            .assertIsDisplayed()
    }
}
