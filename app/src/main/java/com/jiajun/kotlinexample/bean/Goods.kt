package com.jiajun.kotlinexample.bean

/**
 * Created by dan on 2018/7/20/020.
 *
 */
data class Goods(
        val _id: String,
        val createdAt: String,
        val desc: String,
        val images: Array<String>,
        val publishedAt: String,
        val source: String,
        val type: String,
        val url: String,
        val used: Boolean,
        val who: String
) {
    fun hasImg(): Boolean {
        return images.isEmpty()
    }

    fun create() = createdAt.substring(0, 10)
}