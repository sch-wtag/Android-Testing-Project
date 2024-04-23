package com.example.testproject

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.io.FileNotFoundException

class QuoteManagerTest {
    private lateinit var context: Context
    private lateinit var quoteManager: QuoteManager

    @Before
    fun setup() {
        context = ApplicationProvider.getApplicationContext()
        quoteManager = QuoteManager(context)
    }


    @Test(expected = FileNotFoundException::class)
    fun loadQuoteFromAssets_InvalidFileName_FilenameException() {
        quoteManager.loadQuoteFromAssets("")
    }

    @Test(expected = JsonSyntaxException::class)
    fun loadQuoteFromAssets_InvalidJson_JsonException() {
        quoteManager.loadQuoteFromAssets("invalid_quotes.json")
    }

    @Test
    fun loadQuoteFromAssets_ValidJson_ExpectedCount() {
        quoteManager.loadQuoteFromAssets()
        assertEquals(1643, quoteManager.quoteList.size)
    }

    @Test
    fun loadQuoteFromAssets_ValidJson_ExpectedPrevQuote() {
        quoteManager.populateQuotes(arrayOf(
            Quote("text 1", "1"),
            Quote("text 2", "2"),
            Quote("text 3", "3"),
        ))
        assertEquals("3", quoteManager.previousQuote().author)
    }

    @Test
    fun loadQuoteFromAssets_ValidJson_ExpectedNextQuote() {
        quoteManager.populateQuotes(arrayOf(
            Quote("text 1", "1"),
            Quote("text 2", "2"),
            Quote("text 3", "3"),
        ))
        assertEquals("2", quoteManager.nextQuote().author)
    }
}