package com.jiajun.kotlinexample.ui.main.adapter

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

/**
 * Created by dan on 2018/7/24/024.
 *
 */
abstract class BaseBindingAdapter<B:ViewDataBinding>:RecyclerView.Adapter<DataBoundViewHolder<B>>(){

    var mListener:((pos:Int) -> Unit) ?=null

    override fun onBindViewHolder(holder: DataBoundViewHolder<B>, position: Int) {
        holder.binding.root.setOnClickListener { mListener?.invoke(holder.adapterPosition) }
    }

    fun setOnItemClickListener(listener:((pos:Int) -> Unit)){
        mListener = listener;
    }
}