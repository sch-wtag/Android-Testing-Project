package com.example.testproject.helper

object HelperUtils {
    fun isPalindrome (input: String): Boolean {
        val revInput = input.reversed()
        return (input == revInput)
    }
}