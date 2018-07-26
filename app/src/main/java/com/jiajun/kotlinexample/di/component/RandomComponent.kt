package com.jiajun.kotlinexample.di.component

import com.jiajun.kotlinexample.mvp.contract.RandomContract
import com.jiajun.kotlinexample.ui.main.MainActivity
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

/**
 * Created by dan on 2018/7/26/026.
 *
 */
@Subcomponent(modules = arrayOf(RandomModule::class))
interface RandomComponent{
        fun inject(activity:MainActivity)
}
@Module
class RandomModule(private val mView:RandomContract.View){
    @Provides fun getView() = mView
}