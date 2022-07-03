package com.github.ryutaro.daily_ranking

import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.espresso.Espresso
import androidx.test.espresso.NoActivityResumedException
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class NavigationTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var home: String
    private lateinit var profile: String

    @Before
    fun setUp() {
        composeTestRule.activity.apply {
            home = getString(R.string.home)
            profile = getString(R.string.profile)
        }
    }

    @Test
    fun firstScreenIsHomeScreen() {
        composeTestRule.apply {
            onNodeWithText(home).assertIsSelected()
        }
    }

    @Test(expected = NoActivityResumedException::class)
    fun homeDestinationBackQuitsApp() {
        composeTestRule.apply {
            onNodeWithText(profile).performClick()
            onNodeWithText(home).performClick()
            Espresso.pressBack()
        }
    }

    @Test
    fun userCanGoProfileScreen() {
        composeTestRule.apply {
            onNodeWithText(profile).performClick()
            onNodeWithText(profile).assertIsSelected()
        }
    }
}
