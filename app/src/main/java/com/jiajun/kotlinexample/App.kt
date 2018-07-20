package com.jiajun.kotlinexample

import android.app.Application
import android.content.Context
import android.widget.Toast
import com.jiajun.kotlinexample.di.component.ApiComponent
import com.jiajun.kotlinexample.di.component.DaggerApiComponent
import javax.inject.Inject

/**
 * Created by dan on 2018/7/20/020.
 *
 */
class App : Application() {
    companion object {
        lateinit var instance: App

    }

    init {
        instance = this;
    }

    @Inject
    lateinit var apiComponent: ApiComponent

    override fun onCreate() {
        super.onCreate()
        DaggerApiComponent.builder().build().inject(this)
    }

    /**
     * 拓展
     */
    fun Context.getMainComponent() = App.instance.apiComponent
    fun Context.toast(msg: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, msg, length).show()
    }
}