package com.luge.mvi.myui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class HomeActivity:AppCompatActivity(){
    private val homeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initData()
        observeViewmodel()

    }

    private fun initData() {


    }

    private fun observeViewmodel() {
        
    }
}