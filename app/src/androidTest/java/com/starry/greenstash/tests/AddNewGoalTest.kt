package com.starry.greenstash.tests

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.starry.greenstash.base.BaseTest
import com.starry.greenstash.helpers.TestOnboardingHelper
import com.starry.greenstash.helpers.TestOnboardingHelper.disableAllOnboardingHints
import com.starry.greenstash.screens.AddGoalScreen
import com.starry.greenstash.screens.HomeScreen
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class AddNewGoalTest : BaseTest() {

    val homeScreen = HomeScreen(composeTestRule)
    val addGoalScreen = AddGoalScreen(composeTestRule)
    val amount = "555"
    val newGoal = "Learning Fund"

    @Before
    fun setup() {
        runBlocking {
            val context = ApplicationProvider.getApplicationContext<Context>()
            TestOnboardingHelper.skipOnboarding(context)

            disableAllOnboardingHints()
        }
    }

    @Test
    fun addNewGoalTest() = run {
        step("click new goal button") {
            homeScreen {
                newGoalButton.assertIsDisplayed()
                newGoalButton.performClick()
            }
        }
        step("input goal title") {
            addGoalScreen.goalTitleInput.perform {
                assertIsDisplayed()
                performClick()
                performTextInput(newGoal)
            }
        }
        step("input target amount") {
            addGoalScreen.targetAmountInput.perform {
                assertIsDisplayed()
                performClick()
                performTextInput(amount)
            }
        }
        step("click set goal button") {
            addGoalScreen.setNewSavingGoalButton {
                performScrollTo()
                assertIsDisplayed()
                performClick()
            }
        }

        step("Verify that the goal was updated") {
            homeScreen.assertIsDisplayed()
            step("check goal title") {
                homeScreen.goalTitleText.assertTextEquals(newGoal)
            }
            step("check target amount") {
                homeScreen.goalStatusText.assertTextContains("${amount}", substring = true)
            }
        }
    }
}
