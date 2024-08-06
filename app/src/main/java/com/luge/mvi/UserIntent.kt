package com.luge.mvi

sealed class UserIntent{
    object GetBanner:UserIntent()
}