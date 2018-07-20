package com.jiajun.kotlinexample.base

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by wing on 11/23/16.
 */
 class DataBoundViewHolder<T : ViewDataBinding>(val binding:T) : RecyclerView.ViewHolder(binding.root) {
}
