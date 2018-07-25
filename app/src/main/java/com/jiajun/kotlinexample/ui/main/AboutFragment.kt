package com.jiajun.kotlinexample.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jiajun.kotlinexample.base.BaseBindingFragment
import com.jiajun.kotlinexample.databinding.FragmentAboutBinding
import kotlinx.android.synthetic.main.fragment_about.*

/**
 * Created by dan on 2018/7/23/023.
 *
 */
class AboutFragment:BaseBindingFragment<FragmentAboutBinding>(){

    override fun createDataBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): FragmentAboutBinding {
        return FragmentAboutBinding.inflate(inflater,container,false)
    }

    override fun initView() {
        val text = "Kotlin \n"
                .plus("Dagger 2\n")
                .plus("Rxjava\n")
                .plus("Retrofit 2\n")
                .plus("OkHttp 3\n")
                .plus("DataBinding\n")
                .plus("DeepLinkDispatch\n")
                .plus("Gson\n")
                .plus("Glide")
       mBinging.tvThank.text = text
    }

}