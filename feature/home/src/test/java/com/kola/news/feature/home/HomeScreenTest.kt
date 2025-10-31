package com.kola.news.feature.home

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.kola.news.core.designsystem.theme.KolaNewsTheme
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun homeScreen_displaysWelcomeMessages() {
        composeTestRule.setContent {
            KolaNewsTheme {
                HomeScreen()
            }
        }

        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithText("Welcome to KolaNews").assertIsDisplayed()
        composeTestRule
            .onNodeWithText("Catch up with curated stories on your home feed.")
            .assertIsDisplayed()
    }
}
