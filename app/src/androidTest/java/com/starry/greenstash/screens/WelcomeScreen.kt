package com.starry.greenstash.screens

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.starry.greenstash.ui.C
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

class WelcomeScreen(
    semanticsProvider: SemanticsNodeInteractionsProvider
) : ComposeScreen<WelcomeScreen>(semanticsProvider) {

    val currencySelectorButton: KNode = child {
        hasTestTag(C.WelcomeScreen.currencySelectorButton)
    }

    val getStartedButton: KNode = child {
        hasTestTag(C.WelcomeScreen.getStartedButton)
    }
}