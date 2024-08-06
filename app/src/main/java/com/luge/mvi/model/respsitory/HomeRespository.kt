package com.luge.mvi.model.respsitory

import com.luge.mvi.base.BaseData
import com.luge.mvi.base.BaseRepository
import com.luge.mvi.model.bean.Luge

class HomeRespository:BaseRepository() {

    suspend fun requestPost():BaseData<List<Luge>> {
        return post {
            //
        }
    }
}