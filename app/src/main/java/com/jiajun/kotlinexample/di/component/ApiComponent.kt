package com.jiajun.kotlinexample.di.component

import com.jiajun.kotlinexample.App
import com.jiajun.kotlinexample.di.module.ApiModule
import com.jiajun.kotlinexample.mvp.model.GoodsModel
import com.jiajun.kotlinexample.ui.main.AndroidFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by dan on 2018/7/20/020.
 *
 */
@Singleton
@Component(modules = arrayOf(ApiModule::class))
interface ApiComponent{
    fun inject(app: App)

    fun plus(module: GoodsModule):GoodsComponent
    fun plus(module: RandomModule):RandomComponent

}