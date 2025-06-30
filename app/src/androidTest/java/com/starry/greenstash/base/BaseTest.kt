package com.starry.greenstash.base

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.components.composesupport.config.addComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.starry.greenstash.MainActivity
import org.junit.Rule

open class BaseTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder
        .withForcedAllureSupport()
        .addComposeSupport()
) {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()
}