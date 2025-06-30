package com.starry.greenstash.screens

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.starry.greenstash.ui.C
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

class HomeScreen(semanticsProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<HomeScreen>(semanticsProvider) {

    val newGoalButton: KNode = child {
        hasTestTag(C.HomeScreen.newGoalButton)
    }

    val goalTitleText: KNode = child {
        hasTestTag(C.HomeScreen.goalTitleText)
    }

    val editGoalButton: KNode = child {
        hasTestTag(C.HomeScreen.editGoalButton)
    }

    val goalStatusText: KNode = child {
        hasTestTag(C.HomeScreen.goalStatusText)
    }
}