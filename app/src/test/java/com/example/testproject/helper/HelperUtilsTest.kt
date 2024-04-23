package com.example.testproject.helper

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

// parameterized test
@RunWith(value = Parameterized::class)
class HelperUtilsTest (private val input: String, private val expectedValue: Boolean) {
    private lateinit var helper: HelperUtils

    @Before
    fun setup() { helper = HelperUtils }

    @Test
    fun test() {
        val result = helper.isPalindrome(input)
        assertEquals(expectedValue, result)
    }

    companion object {
        @JvmStatic
        @Parameters(name = "{index}: {0} is palindrome - {1}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("hello", false),
                arrayOf("level", true),
                arrayOf("a", true),
                arrayOf("", true),
                arrayOf("abc", false),
            )
        }
    }
}