package com.jiajun.kotlinexample.ui.main

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jiajun.kotlinexample.base.BaseBindingFragment
import com.jiajun.kotlinexample.bean.Goods
import com.jiajun.kotlinexample.databinding.RecyclerViewBinding
import com.jiajun.kotlinexample.di.component.GoodsModule
import com.jiajun.kotlinexample.getMainComponent
import com.jiajun.kotlinexample.mvp.contract.GoodsContract
import com.jiajun.kotlinexample.mvp.model.GoodsModel
import com.jiajun.kotlinexample.mvp.presenter.GoodsPresenter
import com.jiajun.kotlinexample.ui.main.adapter.GoodsAdapter
import com.wingsofts.gankclient.router.GankClientUri
import com.wingsofts.gankclient.router.GankRouter
import kotlinx.android.synthetic.main.recycler_view.*
import java.net.URLEncoder
import java.util.ArrayList
import javax.inject.Inject

/**
 * Created by dan on 2018/7/23/023.
 *
 */
class AndroidFragment : BaseBindingFragment<RecyclerViewBinding>(), GoodsContract.View {


    private var mList = ArrayList<Goods>()
    private lateinit var mAdapter: GoodsAdapter
    private var mPage = 1
    @Inject
    lateinit var mPresenter: GoodsPresenter


    override fun createDataBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): RecyclerViewBinding {
        return RecyclerViewBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        var manage = LinearLayoutManager(context)
        manage.orientation = LinearLayoutManager.VERTICAL
        mAdapter = GoodsAdapter(mList)

        context!!.getMainComponent().plus(GoodsModule(this)).inject(this)
        with(mBinging) {
            recyclerView.adapter = mAdapter
            recyclerView.layoutManager = manage
            recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (!recyclerView!!.canScrollVertically(1)) {
                        mPresenter.getData(++mPage, ANDROID)
                    }
                }
            })
        }

        mPresenter.getData(mPage, ANDROID)
        mAdapter.setOnItemClickListener { pos ->
            val url = URLEncoder.encode(mList[pos].url)
            GankRouter.router(context!!, GankClientUri.DETAIL + url)

        }

    }

    override fun setData(results: List<Goods>) {
        mList.addAll(results)
        mAdapter.notifyDataSetChanged()
    }

    /**
     * 单例 final字段
     */
    companion object {
        val ANDROID = "ANDROID"
        fun newInstance(): AndroidFragment {
            val fragment = AndroidFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }
}