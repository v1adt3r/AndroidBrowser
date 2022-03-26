package com.example.webbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout

const val W = ViewGroup.LayoutParams.WRAP_CONTENT
const val M = ViewGroup.LayoutParams.MATCH_PARENT

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val edit = EditText(this)
        edit.layoutParams = ViewGroup.LayoutParams(M, W)

        val button = Button(this)
        button.layoutParams = ViewGroup.LayoutParams(W, W)
        button.text = "Press me!"

        val web = WebView(this)
        web.layoutParams = ViewGroup.LayoutParams(M, M)
        web.webViewClient = WebViewClient()

        val linearLayout = LinearLayout(this)
        linearLayout.layoutParams = ViewGroup.LayoutParams(M, M)
        linearLayout.orientation = LinearLayout.VERTICAL

        linearLayout.addView(edit)
        linearLayout.addView(button)
        linearLayout.addView(web)

        button.setOnClickListener(View.OnClickListener {
            val url = edit.text.toString()
            web.loadUrl(url)
        })

        setContentView(linearLayout)
    }
}