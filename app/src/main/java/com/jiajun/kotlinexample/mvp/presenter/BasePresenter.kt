package com.jiajun.kotlinexample.mvp.presenter

import rx.Subscription
import rx.subscriptions.CompositeSubscription

/**
 * Created by dan on 2018/7/25/025.
 *
 */
open class BasePresenter {
    var compositeSubscription = CompositeSubscription()

    protected fun addSubscription(subscription: Subscription) {
        compositeSubscription.add(subscription)
    }
    fun unSubscription(subscription: Subscription){
        if(compositeSubscription.hasSubscriptions()){
            compositeSubscription.unsubscribe()
        }
    }
}