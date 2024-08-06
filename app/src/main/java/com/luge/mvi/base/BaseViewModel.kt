package com.luge.mvi.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BaseViewModel<UiState:IUiState,UiIntent:IUiIntent>:ViewModel() {
    //viewmodel

    private val _uiStateFLow = MutableStateFlow(initUiState())

    private val _loadUiIntentFlow:Channel<LoadUiIntent> = Channel()
    val loadUiIntentFlow:Flow<LoadUiIntent> = _loadUiIntentFlow.receiveAsFlow()

    private val _uiIntentFlow:Channel<UiIntent> = Channel()
    val UiIntentFlow:Flow<UiIntent> = _uiIntentFlow.receiveAsFlow()


    init {
        viewModelScope.launch {
            UiIntentFlow.collect {
                handleIntent(it)
            }
        }

    }

    abstract fun handleIntent(intent: UiIntent)
    abstract fun initUiState():UiState


    protected fun<T:Any> requestDataWithFlow(
        showLoading:Boolean = true,
        request:suspend ()->BaseData<T>,
        successCallback:(T)->Unit,
        errorCallback:suspend (String)->Unit = {
            errMsg ->
            sendLoadUiIntent(LoadUiIntent.Error(errMsg))
        }
    ){
        viewModelScope.launch {
            if(showLoading)
                sendLoadUiIntent(LoadUiIntent.Loading(true))
            val baseData:BaseData<T>
            try {
                baseData = request()
                when(baseData.state){
                    ReqState.Success -> {
                        sendLoadUiIntent(LoadUiIntent.ShowMainView)
                        baseData.data?.let {
                            successCallback(it)
                        }
                    }
                    ReqState.Error -> baseData.msg?.let {
                        error(it)
                    }
                }
            }catch (e:Exception){
                e.message?.let {
                    errorCallback(it)
                }
            }finally {
                if(showLoading)
                    sendLoadUiIntent(LoadUiIntent.Loading(false))
            }
        }

    }


    private fun sendLoadUiIntent(loadUiIntent: LoadUiIntent) {
        viewModelScope.launch {
            _loadUiIntentFlow.send(loadUiIntent)
        }
    }

    protected fun sendUiState(copy:UiState.()->UiState){
        _uiStateFLow.update {
            copy(_uiStateFLow.value)
        }
    }
}