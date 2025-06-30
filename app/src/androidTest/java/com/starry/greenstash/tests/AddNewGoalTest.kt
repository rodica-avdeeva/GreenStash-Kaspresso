package com.starry.greenstash.tests

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.starry.greenstash.annotations.SmokeTest
import com.starry.greenstash.base.BaseTest
import com.starry.greenstash.helpers.TestOnboardingHelper
import com.starry.greenstash.helpers.TestOnboardingHelper.disableAllOnboardingHints
import com.starry.greenstash.screens.GoalEditorScreen
import com.starry.greenstash.screens.HomeScreen
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class AddNewGoalTest : BaseTest() {

    val homeScreen = HomeScreen(composeTestRule)
    val goalEditorScreen = GoalEditorScreen(composeTestRule)
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

    @SmokeTest
    @Test
    fun addNewGoalTest() = run {
        step("Open the goal creation screen") {
            homeScreen {
                newGoalButton.assertIsDisplayed()
                newGoalButton.performClick()
            }
        }
        step("Enter the goal title") {
            goalEditorScreen.goalTitleInput.perform {
                assertIsDisplayed()
                performClick()
                performTextInput(newGoal)
            }
        }
        step("Enter the target amount") {
            goalEditorScreen.targetAmountInput.perform {
                assertIsDisplayed()
                performClick()
                performTextInput(amount)
            }
        }
        step("Save the new goal") {
            goalEditorScreen.setNewSavingGoalButton {
                performScrollTo()
                assertIsDisplayed()
                performClick()
            }
        }

        step("Verify that the goal was added") {
            homeScreen.assertIsDisplayed()
            step("Check that the goal title is displayed") {
                homeScreen.goalTitleText.assertTextEquals(newGoal)
            }
            step("Check that the target amount is correct") {
                homeScreen.goalStatusText.assertTextContains("${amount}", substring = true)
            }
        }
    }
}