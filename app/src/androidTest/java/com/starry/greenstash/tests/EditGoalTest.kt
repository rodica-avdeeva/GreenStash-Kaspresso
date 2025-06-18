package com.starry.greenstash.tests

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.starry.greenstash.base.BaseTest
import com.starry.greenstash.helpers.TestGoalHelper
import com.starry.greenstash.helpers.TestOnboardingHelper
import com.starry.greenstash.helpers.TestOnboardingHelper.disableAllOnboardingHints
import com.starry.greenstash.screens.AddGoalScreen
import com.starry.greenstash.screens.HomeScreen
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class EditGoalTest : BaseTest() {

    val homeScreen = HomeScreen(composeTestRule)
    val addGoalScreen = AddGoalScreen(composeTestRule)
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

    @Test
    fun editGoalTest() = run {
        step("click edit button") {
            homeScreen.editGoalButton.performClick()
        }

        step("edit goal title ") {
            addGoalScreen.goalTitleInput.perform {
                assertIsDisplayed()
                performClick()
                performTextReplacement(newGoal)
            }
        }

        step("edit target amount") {
            addGoalScreen.targetAmountInput.perform {
                assertIsDisplayed()
                performClick()
                performTextReplacement(amount)
            }
        }

        step("click save button") {
            addGoalScreen.setNewSavingGoalButton {
                performScrollTo()
                assertIsDisplayed()
                performClick()
            }
        }

        step("check edited goal") {
            step("check goal title") {
                homeScreen.goalTitleText.assertTextEquals(newGoal)
            }
            step("check target amount") {
                homeScreen.goalStatusText.assertTextContains("${amount}", substring = true)
            }
        }
    }
}