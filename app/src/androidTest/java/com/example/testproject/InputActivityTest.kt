package com.example.testproject

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class InputActivityTest {

    @get:Rule
    val activityScenarioRule = activityScenarioRule<InputActivity>()

    @Test
    fun testSaveButton_ExpectedNextScreen() {
        onView(withId(R.id.etTitle)).perform(typeText("Hello"))
        onView(withId(R.id.etText)).perform(typeText("world!"))
        closeSoftKeyboard()
        onView(withId(R.id.btnSave)).perform(click())
        onView(withId(R.id.tvMsg)).check(matches(withText("title: Hello, text: world!")))
    }
}