package com.jiajun.kotlinexample.ui.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jiajun.kotlinexample.base.BaseBindingFragment
import com.jiajun.kotlinexample.databinding.RecyclerViewBinding
import kotlinx.android.synthetic.main.recycler_view.*

/**
 * Created by dan on 2018/7/23/023.
 *
 */
class GirlFragment:BaseBindingFragment<RecyclerViewBinding>() {

    override fun createDataBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): RecyclerViewBinding {
        return RecyclerViewBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        var manage = LinearLayoutManager(context)
        manage.orientation = LinearLayoutManager.VERTICAL
        mBinging.recyclerView.layoutManager = manage
    }


    companion object {
        val GIRL = "GIRL"
        fun newInstance(): GirlFragment {
            val fragment = GirlFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }
}