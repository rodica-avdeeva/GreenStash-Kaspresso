package com.starry.greenstash.helpers

import android.content.Context
import android.graphics.Bitmap
import androidx.test.core.app.ApplicationProvider
import com.starry.greenstash.database.core.AppDatabase
import com.starry.greenstash.database.goal.Goal
import com.starry.greenstash.database.goal.GoalPriority

object TestGoalHelper {

    private fun getDatabase(): AppDatabase {
        val context = ApplicationProvider.getApplicationContext<Context>()
        return AppDatabase.getInstance(context)
    }

    suspend fun insertTestGoal(
        title: String = "Test Goal",
        targetAmount: Double = 1000.0,
        deadline: String = "",
        goalImage: Bitmap? = null,
        additionalNotes: String = "",
        priority: GoalPriority = GoalPriority.Normal,
        reminder: Boolean = false,
        goalIconId: String? = null,
        archived: Boolean = false
    ): Goal {
        val goal = Goal(
            title = title,
            targetAmount = targetAmount,
            deadline = deadline,
            goalImage = goalImage,
            additionalNotes = additionalNotes,
            priority = priority,
            reminder = reminder,
            goalIconId = goalIconId,
            archived = archived
        )

        val db = getDatabase()
        val newId = db.getGoalDao().insertGoal(goal)
        goal.goalId = newId
        return goal
    }
}