package com.jiajun.kotlinexample.mvp.presenter

import com.jiajun.kotlinexample.mvp.contract.RandomContract
import com.jiajun.kotlinexample.mvp.model.RandomModel
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by dan on 2018/7/26/026.
 *
 */
class RandomPresenter
@Inject constructor(private val mModel:RandomModel
                    ,private val mView:RandomContract.View):RandomContract.Presenter,BasePresenter(){
    override fun getRandom(type: String) {
            addSubscription(mModel.getRandom(type).observeOn(AndroidSchedulers.mainThread()).subscribe({
                res ->
                if(!res.error){
                    mView.onRandom(res.results[0])
                }
            },{}))
    }

}