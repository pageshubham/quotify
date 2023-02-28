package com.quotify.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var quoteViewModel: QuoteViewModel

    private val quoteText: TextView
        get() = findViewById(R.id.quoteText)

    private val quoteAuthor: TextView
        get() = findViewById(R.id.quoteAuthor)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quoteViewModel = ViewModelProvider(this, QuoteViewModelFactory(application)).get(QuoteViewModel::class.java)
        setQuote(quoteViewModel.getQuote())

    }//onCreate()

    private fun setQuote(quote: Quote) {
        quoteText.text = quote.text
        quoteAuthor.text = quote.author
    }

    fun onPrevious(view: View) {
        setQuote(quoteViewModel.previousQuote())
    }

    fun onNext(view: View) {
        setQuote(quoteViewModel.nextQuote())
    }


}