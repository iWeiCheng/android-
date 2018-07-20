package com.jiajun.kotlinexample.di.component

import com.jiajun.kotlinexample.daggertest.MainModule
import com.jiajun.kotlinexample.ui.main.MainActivity
import dagger.Component

/**
 * Created by dan on 2018/7/20/020.
 *
 */
@Component(modules = [(MainModule::class)])
interface MainComponent {
    fun inject(activity: MainActivity)
}