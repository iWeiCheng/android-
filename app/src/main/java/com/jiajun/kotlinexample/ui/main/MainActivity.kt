package com.jiajun.kotlinexample.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.util.Log
import com.jiajun.kotlinexample.R
import com.jiajun.kotlinexample.base.BaseBindingActivity
import com.jiajun.kotlinexample.bean.Goods
import com.jiajun.kotlinexample.databinding.ActivityMainBinding
import com.jiajun.kotlinexample.di.component.RandomModule
import com.jiajun.kotlinexample.getMainComponent
import com.jiajun.kotlinexample.mvp.contract.RandomContract
import com.jiajun.kotlinexample.mvp.presenter.GoodsPresenter
import com.jiajun.kotlinexample.mvp.presenter.RandomPresenter
import com.jiajun.kotlinexample.toast
import com.wingsofts.gankclient.router.GankClientUri
import com.wingsofts.gankclient.router.GankRouter
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URLEncoder
import javax.inject.Inject

/**
 * Created by dan on 2018/7/20/020.
 *
 */
class MainActivity : BaseBindingActivity<ActivityMainBinding>(),RandomContract.View {

    lateinit var mFragments:MutableList<Fragment>

    @Inject
    lateinit var mPresenter: RandomPresenter


    override fun createDataBinding(savedInstanceState: Bundle?): ActivityMainBinding {
       return DataBindingUtil.setContentView(this,R.layout.activity_main)
    }

    override fun initView() {
        getMainComponent().plus(RandomModule(this)).inject(this)
        initFragments()
        viewPager.adapter = object:FragmentPagerAdapter(supportFragmentManager){
            override fun getItem(position: Int): Fragment =mFragments[position]
            override fun getCount(): Int = mFragments.size
        }
        viewPager.offscreenPageLimit = mFragments.size
        navigationView.setOnNavigationItemSelectedListener { item ->
            var tab = 0
            when (item.itemId) {
                R.id.menu_android -> tab = 0
                R.id.menu_ios -> tab = 1
                R.id.menu_girl -> tab = 2
                R.id.menu_about -> tab = 3
            }
            viewPager.currentItem = tab
            true
        }
        floatingButton.setOnClickListener {
            mPresenter.getRandom("Android")
        }
    }

    private fun initFragments(){
        mFragments = ArrayList()
        mFragments.add(AndroidFragment.newInstance())
        mFragments.add(IOSFragment.newInstance())
        mFragments.add(GirlFragment.newInstance())
        mFragments.add(AboutFragment())
    }

    override fun onRandom(goods: Goods) {
        val url = URLEncoder.encode(goods.url)
        toast("手气不错～")
        GankRouter.router(this, GankClientUri.DETAIL + url)
    }

}