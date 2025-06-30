package com.starry.greenstash.tests

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.starry.greenstash.annotations.SmokeTest
import com.starry.greenstash.base.BaseTest
import com.starry.greenstash.helpers.TestGoalHelper
import com.starry.greenstash.helpers.TestOnboardingHelper
import com.starry.greenstash.helpers.TestOnboardingHelper.disableAllOnboardingHints
import com.starry.greenstash.screens.GoalEditorScreen
import com.starry.greenstash.screens.HomeScreen
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class EditGoalTest : BaseTest() {

    val homeScreen = HomeScreen(composeTestRule)
    val goalEditorScreen = GoalEditorScreen(composeTestRule)
    val amount = "555"
    val newGoal = "Masterplan"

    @Before
    fun setup() {
        runBlocking {
            val context = ApplicationProvider.getApplicationContext<Context>()
            TestOnboardingHelper.skipOnboarding(context)
            TestGoalHelper.insertTestGoal(title = "Learning Fund")

            disableAllOnboardingHints()
        }
    }

    @SmokeTest
    @Test
    fun editGoalTest() = run {
        step("Open the goal editor") {
            homeScreen.editGoalButton.performClick()
        }

        step("Edit the goal title") {
            goalEditorScreen.goalTitleInput.perform {
                assertIsDisplayed()
                performClick()
                performTextReplacement(newGoal)
            }
        }

        step("Edit the target amount") {
            goalEditorScreen.targetAmountInput.perform {
                assertIsDisplayed()
                performClick()
                performTextReplacement(amount)
            }
        }

        step("Save the updated goal") {
            goalEditorScreen.setNewSavingGoalButton {
                performScrollTo()
                assertIsDisplayed()
                performClick()
            }
        }

        step("Verify that the goal was updated") {
            step("Check that the goal title is updated") {
                homeScreen.goalTitleText.assertTextEquals(newGoal)
            }
            step("Check that the target amount is updated") {
                homeScreen.goalStatusText.assertTextContains("${amount}", substring = true)
            }
        }
    }
}