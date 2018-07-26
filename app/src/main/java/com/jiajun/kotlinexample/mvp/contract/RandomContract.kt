package com.jiajun.kotlinexample.mvp.contract

import com.jiajun.kotlinexample.bean.Goods
import com.jiajun.kotlinexample.bean.JsonResult
import rx.Observable

/**
 * Created by dan on 2018/7/26/026.
 *
 */
interface RandomContract {
    interface View{
        fun onRandom(goods:Goods)
    }
    interface Model{
        fun getRandom(type:String):Observable<JsonResult<List<Goods>>>
    }
    interface Presenter{
        fun getRandom(type:String)
    }
}