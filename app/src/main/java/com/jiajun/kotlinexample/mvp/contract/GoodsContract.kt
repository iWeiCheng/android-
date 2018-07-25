package com.jiajun.kotlinexample.mvp.contract

import com.jiajun.kotlinexample.bean.Goods
import com.jiajun.kotlinexample.bean.JsonResult
import rx.Observable

/**
 * Created by dan on 2018/7/24/024.
 *
 */
interface GoodsContract{
    interface View{
        fun setData(results:List<Goods>)
    }
    interface Model{
        fun getData(page:Int,type:String): Observable<JsonResult<List<Goods>>>
    }
    interface Presenter{
        open fun getData(page:Int,type:String)
    }
}