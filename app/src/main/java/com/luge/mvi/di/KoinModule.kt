package com.luge.mvi.di

import androidx.compose.ui.input.key.Key.Companion.Home
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repoModule = module{
    single{
//        Home
    }

}

val viewModule = module{
    viewModel{
//        Home
    }

}

val appModule = listOf(viewModule, repoModule)