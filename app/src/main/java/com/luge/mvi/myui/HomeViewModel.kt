package com.luge.mvi.myui

import com.luge.mvi.base.BaseViewModel
import com.luge.mvi.model.respsitory.HomeRespository

class HomeViewModel(private val homeRespository: HomeRespository):BaseViewModel<HomeState,HomeIntent>() {
    override fun handleIntent(intent: HomeIntent) {
        when(intent){
            HomeIntent.GetBanner->{
                //todo
            }

            is HomeIntent.GetNews->{
                requestDataWithFlow(
                    showLoading = false,
                    request = {
                        homeRespository.requestPost()
                    },
                    successCallback = {
                        data ->
                        sendUiState {
                            copy(bannerIUiState = BannrUiState.SUCCESS(data))
                        }
                    },
                    errorCallback = {

                    }
                )
            }
        }
    }

    override fun initUiState(): HomeState {
       return HomeState(BannrUiState.INIT,NewsUiState.INIT)
    }
}