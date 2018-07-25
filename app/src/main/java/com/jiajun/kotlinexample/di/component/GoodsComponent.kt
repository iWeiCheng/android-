package com.jiajun.kotlinexample.di.component

import com.jiajun.kotlinexample.mvp.contract.GoodsContract
import com.jiajun.kotlinexample.ui.main.AndroidFragment
import com.jiajun.kotlinexample.ui.main.GirlFragment
import com.jiajun.kotlinexample.ui.main.IOSFragment
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

/**
 * Created by dan on 2018/7/25/025.
 *
 */
@Subcomponent(modules = arrayOf(GoodsModule::class))
interface GoodsComponent {
    fun inject(fragment: AndroidFragment)
    fun inject(fragment: IOSFragment)
    fun inject(fragment: GirlFragment)
}

@Module
class GoodsModule(private val mView: GoodsContract.View) {
    @Provides
    fun getView() = mView
}