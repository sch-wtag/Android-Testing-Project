package com.example.testproject

import com.google.gson.Gson
import android.content.Context

class QuoteManager (private val context: Context) {
    var quoteList: Array<Quote> = emptyArray()
    private var index = 0

    init {
        quoteList = loadQuoteFromAssets()
    }

    fun loadQuoteFromAssets(fileName: String = "quotes.json"): Array<Quote> {
        val inputStream = context.assets.open(fileName)
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        return gson.fromJson(json, Array<Quote>::class.java)
    }

    fun populateQuotes(quotes: Array<Quote>) {
        quoteList = quotes
    }

    fun getQuote() = quoteList[index]

    fun nextQuote() = quoteList[++index % quoteList.size]

    fun previousQuote() = quoteList[(--index + quoteList.size) % quoteList.size]
}