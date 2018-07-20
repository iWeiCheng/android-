package com.jiajun.kotlinexample.widget

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by dan on 2018/7/20/020.
 *
 */
class NoScrollViewPager : ViewPager {

    private val isPagingEnabled = false

    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return super.onTouchEvent(ev) && isPagingEnabled
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return super.onInterceptTouchEvent(ev) && isPagingEnabled
    }

}