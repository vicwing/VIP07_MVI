package com.luge.mvi.base

import androidx.annotation.Keep

@Keep
interface IUiState
@Keep
interface IUiIntent //event

sealed class LoadUiIntent{
    data class Loading(var isShow:Boolean):LoadUiIntent()
    object ShowMainView:LoadUiIntent()
    data class Error(var errMsg:String):LoadUiIntent()

}



