package com.luge.mvi.base

import android.app.Activity
import android.os.Bundle

abstract class BaseActivity :Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView(savedInstanceState)
        initData(savedInstanceState)
    }

    abstract fun initView(savedInstanceState: Bundle?)
    abstract fun initData(savedInstanceState: Bundle?)


}