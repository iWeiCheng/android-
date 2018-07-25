package com.jiajun.kotlinexample.mvp.model

import com.jiajun.kotlinexample.api.GankApi
import com.jiajun.kotlinexample.bean.Goods
import com.jiajun.kotlinexample.bean.JsonResult
import com.jiajun.kotlinexample.mvp.contract.GoodsContract
import com.jiajun.kotlinexample.ui.main.AndroidFragment
import com.jiajun.kotlinexample.ui.main.GirlFragment
import com.jiajun.kotlinexample.ui.main.IOSFragment
import rx.Observable
import javax.inject.Inject

/**
 * Created by dan on 2018/7/25/025.
 *
 */
class GoodsModel
@Inject constructor(private val api: GankApi) : GoodsContract.Model {
    override fun getData(page: Int, type: String): Observable<JsonResult<List<Goods>>> {
        when (type) {
            AndroidFragment.ANDROID -> return api.getAndroidData(page)
            IOSFragment.IOS -> return api.getiOSData(page)
            GirlFragment.GIRL -> return api.getGirlData(page)
            else -> return api.getAndroidData(page)
        }
    }

}