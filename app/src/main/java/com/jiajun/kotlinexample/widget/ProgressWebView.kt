package com.jiajun.kotlinexample.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.AbsoluteLayout
import android.widget.ProgressBar
import com.jiajun.kotlinexample.R

/**
 * Created by dan on 2018/7/20/020.
 *
 */
class ProgressWebView(context: Context, attr: AttributeSet) : WebView(context, attr) {
    private val progressBar: ProgressBar

    init {
        progressBar = ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal)
        progressBar.layoutParams = AbsoluteLayout.LayoutParams(AbsoluteLayout.LayoutParams.MATCH_PARENT,
                10, 0, 0)
        val drawable = context.resources.getDrawable(R.drawable.progress_bar)
        progressBar.progressDrawable = drawable
        addView(progressBar)
        webChromeClient = WebChromeClient()
        settings.builtInZoomControls = true
    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        val lp = progressBar.layoutParams as AbsoluteLayout.LayoutParams
        lp.x = l
        lp.y = t
        progressBar.layoutParams = lp
        super.onScrollChanged(l, t, oldl, oldt)
    }

    inner class WebChromeClint : WebChromeClient() {
        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            when (newProgress) {
                100 -> progressBar.visibility = View.GONE
                else -> {
                    if (progressBar.visibility == View.GONE) progressBar.visibility = View.VISIBLE
                    progressBar.progress = newProgress
                }
            }
            super.onProgressChanged(view, newProgress)
        }

    }
}