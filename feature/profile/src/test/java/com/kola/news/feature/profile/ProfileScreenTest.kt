package com.kola.news.feature.profile

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.kola.news.core.designsystem.theme.KolaNewsTheme
import org.junit.Rule
import org.junit.Test

class ProfileScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun profileScreen_displaysProfileMessages() {
        composeTestRule.setContent {
            KolaNewsTheme {
                ProfileScreen()
            }
        }

        composeTestRule.onNodeWithText("Your Profile").assertIsDisplayed()
        composeTestRule
            .onNodeWithText("Manage saved topics and reading history here.")
            .assertIsDisplayed()
    }
}
