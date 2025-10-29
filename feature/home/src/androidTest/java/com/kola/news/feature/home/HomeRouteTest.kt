package com.kola.news.feature.home

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
class HomeRouteTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun homeRoute_showsHomeScreenContent() {
        composeTestRule.setContent {
            KolaNewsTheme {
                HomeRoute()
            }
        }

        composeTestRule.onNodeWithText("Welcome to KolaNews").assertIsDisplayed()
        composeTestRule
            .onNodeWithText("Catch up with curated stories on your home feed.")
            .assertIsDisplayed()
    }
}
