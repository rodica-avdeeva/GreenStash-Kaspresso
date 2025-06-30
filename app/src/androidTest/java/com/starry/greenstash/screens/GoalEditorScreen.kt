package com.starry.greenstash.screens

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.starry.greenstash.ui.C
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

class GoalEditorScreen(semanticsProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<GoalEditorScreen>(semanticsProvider) {

    val goalTitleInput: KNode = child {
        hasTestTag(C.GoalEditorScreen.goalTitleInput)
    }

    val targetAmountInput: KNode = child {
        hasTestTag(C.GoalEditorScreen.targetAmountInput)
    }

    val setNewSavingGoalButton: KNode = child {
        hasTestTag(C.GoalEditorScreen.savingGoalConfirmButton)
    }
}