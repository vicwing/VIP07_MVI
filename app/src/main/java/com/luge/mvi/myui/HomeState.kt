package com.luge.mvi.myui

import com.luge.mvi.MainActivity
import com.luge.mvi.base.IUiIntent
import com.luge.mvi.base.IUiState
import com.luge.mvi.model.bean.Luge

data class HomeState(
    val bannerIUiState:BannrUiState,
    val newsUiState: NewsUiState
):IUiState
//    object GetBanner:HomeState()
//    data class GetNews(val page:Int):HomeState()


sealed class BannrUiState{
    object INIT :BannrUiState()
    data class SUCCESS(val baner:List<Luge>):BannrUiState()
}




sealed class NewsUiState{
    object INIT :NewsUiState()
    data class SUCCESS(val news:Luge):NewsUiState()
}
