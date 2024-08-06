package com.luge.mvi.myui

import com.luge.mvi.MainActivity
import com.luge.mvi.base.IUiIntent

sealed class HomeIntent:IUiIntent {
    object GetBanner:HomeIntent()
    data class GetNews(val page:Int):HomeIntent()
    //todo
}