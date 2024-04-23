package com.example.testproject

import androidx.test.espresso.Espresso.*
import androidx.test.ext.junit.rules.activityScenarioRule
import android.content.Intent
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import org.hamcrest.CoreMatchers.allOf
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun testNextButton_expectedCorrectQuote() {
        onView(withId(R.id.btnNext)).perform(click())
        onView(withId(R.id.tvTitle)).check(matches(withText("Yogi Berra")))
    }

    @Test
    fun testShareButton_expectedIntentChooser() {
        Intents.init()

        val expected = allOf(hasAction(Intent.ACTION_SEND))
        onView(withId(R.id.btnShare)).perform(click())
        intended(expected)

        Intents.release()
    }
}