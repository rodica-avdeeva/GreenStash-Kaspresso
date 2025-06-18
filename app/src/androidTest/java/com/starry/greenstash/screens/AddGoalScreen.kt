package com.starry.greenstash.screens

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.starry.greenstash.ui.C
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

class AddGoalScreen(semanticsProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<AddGoalScreen>(semanticsProvider) {

    val goalTitleInput: KNode = child {
        hasTestTag(C.AddGoalScreen.goalTitleInput)
    }

    val targetAmountInput: KNode = child {
        hasTestTag(C.AddGoalScreen.targetAmountInput)
    }

    val setNewSavingGoalButton: KNode = child {
        hasTestTag(C.AddGoalScreen.savingGoalConfirmButton)
    }
}