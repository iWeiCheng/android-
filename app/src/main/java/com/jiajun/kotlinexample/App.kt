package com.jiajun.kotlinexample

import android.app.Application
import com.jiajun.kotlinexample.di.component.ApiComponent
import com.jiajun.kotlinexample.di.component.DaggerApiComponent
import com.jiajun.kotlinexample.di.module.ApiModule
import com.jiajun.kotlinexample.di.module.AppModule
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
        instance = this
    }

    @Inject
    lateinit var apiComponent: ApiComponent
    override fun onCreate() {
        super.onCreate()
        DaggerApiComponent.builder().apiModule(ApiModule()).appModule(AppModule(this)).build().inject(this)
    }
}