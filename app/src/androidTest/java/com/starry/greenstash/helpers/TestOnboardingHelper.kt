package com.starry.greenstash.helpers

import android.content.Context
import android.content.SharedPreferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.test.core.app.ApplicationProvider
import com.starry.greenstash.other.dataStore
import kotlinx.coroutines.runBlocking

object TestOnboardingHelper {

    private val onboardingKey = booleanPreferencesKey("on_boarding_completed")

    private const val PREFS_NAME = "greenstash_settings"
    private const val HOME_SCREEN_ONBOARDING_BOOL = "show_home_screen_onboarding"
    private const val INPUT_SCREEN_ONBOARDING_BOOL = "show_input_onboarding"
    private const val INPUT_REMOVE_DEADLINE_TIP_BOOL = "input_remove_deadline_tip"
    private const val INFO_TRANSACTION_SWIPE_TIP_BOOL = "info_transaction_swipe_tip"

    fun skipOnboarding(context: Context) = runBlocking {
        context.dataStore.edit { prefs ->
            prefs[onboardingKey] = true
        }
    }

    fun disableAllOnboardingHints() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val prefs: SharedPreferences =
            context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        prefs.edit()
            .putBoolean(HOME_SCREEN_ONBOARDING_BOOL, false)
            .putBoolean(INPUT_SCREEN_ONBOARDING_BOOL, false)
            .putBoolean(INPUT_REMOVE_DEADLINE_TIP_BOOL, false)
            .putBoolean(INFO_TRANSACTION_SWIPE_TIP_BOOL, false)
            .apply()
    }
}