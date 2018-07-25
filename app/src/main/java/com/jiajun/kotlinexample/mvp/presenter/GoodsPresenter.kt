package com.jiajun.kotlinexample.mvp.presenter

import android.util.Log
import com.jiajun.kotlinexample.mvp.contract.GoodsContract
import com.jiajun.kotlinexample.mvp.model.GoodsModel
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by dan on 2018/7/25/025.
 *
 */
class GoodsPresenter
    @Inject constructor(private val mModel:GoodsModel,private val mView:GoodsContract.View)
    :GoodsContract.Presenter,BasePresenter(){
    override fun getData(page: Int, type: String) {
        addSubscription(mModel.getData(page,type).observeOn(AndroidSchedulers.mainThread()).subscribe({ res ->
            if (!res.error) {
                mView.setData(res.results)
            }

        },{e -> Log.e("iWeiCheng","error android presenter"+e.message)}))
    }

}