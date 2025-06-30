
package com.starry.greenstash.screens

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.starry.greenstash.ui.C
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode

class CurrencyPicker(
    semanticsProvider: SemanticsNodeInteractionsProvider
) : ComposeScreen<CurrencyPicker>(semanticsProvider) {

    val currencySearchInput: KNode = child {
        hasTestTag(C.CurrencyPicker.currencySearchInput)
    }

    val currencyOptionItem: KNode = child {
        hasTestTag(C.CurrencyPicker.currencyOptionItem)
    }

    val confirmButton: KNode = child {
        hasTestTag(C.CurrencyPicker.confirmButton)
    }
}