package com.jiajun.kotlinexample

import android.content.Context
import android.widget.Toast

/**
 * Created by dan on 2018/7/23/023.
 *
 */
/**
 * 拓展
 */
fun Context.getMainComponent() = App.instance.apiComponent
fun Context.toast(msg: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, length).show()
}