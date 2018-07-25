package com.jiajun.kotlinexample.base

import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by dan on 2018/7/23/023.
 *
 */
abstract class BaseBindingFragment<B:ViewDataBinding> :Fragment(){

    lateinit var mBinging:B


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinging = createDataBinding(inflater,container, savedInstanceState)
        initView()
        return mBinging.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    abstract fun createDataBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):B

    abstract fun initView()
}