package com.jiajun.kotlinexample.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jiajun.kotlinexample.R
import kotlinx.android.synthetic.main.fragment_about.view.*

/**
 * Created by dan on 2018/7/24/024.
 *
 */
class TestFragment :Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_about,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.tv_thank.text = "testetetetetteetet"
    }

}