package com.jiajun.kotlinexample.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.util.Log
import com.jiajun.kotlinexample.R
import com.jiajun.kotlinexample.base.BaseBindingActivity
import com.jiajun.kotlinexample.databinding.ActivityMainBinding
import com.jiajun.kotlinexample.toast
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by dan on 2018/7/20/020.
 *
 */
class MainActivity : BaseBindingActivity<ActivityMainBinding>() {

    lateinit var mFragments:MutableList<Fragment>

    override fun createDataBinding(savedInstanceState: Bundle?): ActivityMainBinding {
       return DataBindingUtil.setContentView(this,R.layout.activity_main)
    }

    override fun initView() {
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
            toast("hello")
           Log.d("yyy","sssss")
        }
    }

    private fun initFragments(){
        mFragments = ArrayList()
        mFragments.add(AndroidFragment.newInstance())
        mFragments.add(IOSFragment.newInstance())
        mFragments.add(GirlFragment.newInstance())
        mFragments.add(AboutFragment())
    }

}