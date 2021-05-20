package com.mobile.mvvmnewsapi.repository

import com.mobile.mvvmnewsapi.model.ResponseServer
import com.mobile.mvvmnewsapi.network.ConfigRetrofit
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class Repository() {

    //rx
    fun getData(responseSuccess: (ResponseServer) -> Unit, responseError: (Throwable) -> Unit) {

        //rx
        ConfigRetrofit.getRetrofit().getData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                responseSuccess(response)

            }, { e ->
                responseError(e)
            })


    }

}