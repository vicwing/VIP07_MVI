package com.luge.mvi.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding

class BaseBindingActivity<VB: ViewBinding>(
    val block:(LayoutInflater)-> VB
):BaseActivity() {

    private var _bind:VB? = null
    protected val binding:VB
        get() = requireNotNull(_bind)

    override fun initView(savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun initData(savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        _bind = block(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        _bind = null
    }
}