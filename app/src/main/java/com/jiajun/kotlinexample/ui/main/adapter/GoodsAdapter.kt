package com.jiajun.kotlinexample.ui.main.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jiajun.kotlinexample.bean.Goods
import com.jiajun.kotlinexample.databinding.ItemGoodsBinding

/**
 * Created by dan on 2018/7/24/024.
 *
 */
class GoodsAdapter(private val mList:List<Goods>):BaseBindingAdapter<ItemGoodsBinding>(){

    override fun onBindViewHolder(holder: DataBoundViewHolder<ItemGoodsBinding>, position: Int) {
        super.onBindViewHolder(holder, position)
        Log.d("result",mList[position].toString())
        holder.binding.goods = mList[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBoundViewHolder<ItemGoodsBinding> {
        return DataBoundViewHolder(ItemGoodsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
      return mList.size
    }


}