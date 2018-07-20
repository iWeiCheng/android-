package com.jiajun.kotlinexample.di.module

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by dan on 2018/7/20/020.
 *
 */
@Module
class AppModule(private val context: Context) {
    @Provides
    fun provideContext() = this;

}