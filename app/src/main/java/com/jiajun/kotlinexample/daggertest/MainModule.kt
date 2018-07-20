package com.jiajun.kotlinexample.daggertest

import dagger.Module
import dagger.Provides

/**
 * Created by dan on 2018/7/20/020.
 *
 */
@Module
class MainModule {
    @Provides
    fun provideMainService(): MainService {
        return MainServiceImpl()
    }
}