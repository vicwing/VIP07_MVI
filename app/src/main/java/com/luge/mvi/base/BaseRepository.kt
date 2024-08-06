package com.luge.mvi.base

open class BaseRepository {
    suspend fun<T: Any> post(block:suspend ()->BaseData<T>):BaseData<T>{
        var baseData = block.invoke()
        if(baseData.code == 0 ){
            baseData.state = ReqState.Success
        }else{
            baseData.state = ReqState.Error
        }
        return baseData
    }
}