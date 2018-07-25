package com.jiajun.kotlinexample.api


import com.jiajun.kotlinexample.bean.Goods
import com.jiajun.kotlinexample.bean.JsonResult
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable


interface GankApi{

  /**
   * Android所有数据
   */
  @GET("data/Android/10/{page}")
  fun getAndroidData(@Path("page") page:Int):Observable<JsonResult<List<Goods>>>

  /**
    * iOS所有数据
   */
  @GET("data/iOS/10/{page}")
  fun getiOSData(@Path("page") page:Int):Observable<JsonResult<List<Goods>>>

  /**
   * iOS所有数据
   */
  @GET("data/福利/10/{page}")
  fun getGirlData(@Path("page") page:Int):Observable<JsonResult<List<Goods>>>


  /**
   * 手气不错
   */

  @GET("random/data/{type}/1")
  fun getRandom(@Path("type") type:String):Observable<JsonResult<List<Goods>>>
}