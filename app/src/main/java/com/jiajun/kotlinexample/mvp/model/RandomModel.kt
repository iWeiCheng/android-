package com.jiajun.kotlinexample.mvp.model

import com.jiajun.kotlinexample.api.GankApi
import com.jiajun.kotlinexample.bean.Goods
import com.jiajun.kotlinexample.bean.JsonResult
import com.jiajun.kotlinexample.mvp.contract.RandomContract
import rx.Observable
import javax.inject.Inject

/**
 * Created by dan on 2018/7/26/026.
 *
 */
class RandomModel
@Inject constructor(private val api:GankApi):RandomContract.Model{

    override fun getRandom(type: String) :Observable<JsonResult<List<Goods>>>{
        return api.getRandom(type)
    }

}