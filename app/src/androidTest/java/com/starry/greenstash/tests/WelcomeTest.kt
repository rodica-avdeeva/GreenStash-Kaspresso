package com.starry.greenstash.tests

import com.starry.greenstash.base.BaseTest
import com.starry.greenstash.screens.CurrencyPicker
import com.starry.greenstash.screens.WelcomeScreen
import org.junit.Test

class WelcomeTest : BaseTest() {

    val welcomeScreen = WelcomeScreen(composeTestRule)
    val currencyPicker = CurrencyPicker(composeTestRule)
    val currency = "Alban"

    @Test
    fun selectCurrencyTest() = run {

        step("Open currency selector") {
            welcomeScreen.currencySelectorButton.performClick()
        }

        step("Search and select Albanian lek") {
            currencyPicker.currencySearchInput.performTextInput(currency)
            currencyPicker.currencyOptionItem.performClick()
        }

        step("Confirm selected currency") {
            currencyPicker.confirmButton.performClick()
        }

        step("Verify selected currency is displayed") {
            flakySafely { welcomeScreen.currencySelectorButton.assertTextContains(currency, substring = true) }
        }
    }
}