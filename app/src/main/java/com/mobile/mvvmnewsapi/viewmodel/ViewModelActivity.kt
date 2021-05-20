package com.mobile.mvvmnewsapi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobile.mvvmnewsapi.model.ResponseServer
import com.mobile.mvvmnewsapi.repository.Repository

class ViewModelActivity : ViewModel() {

    var repo = Repository()

    var success = MutableLiveData<ResponseServer>()

    var error = MutableLiveData<Throwable>()

    fun Panggil() {
        repo.getData({
            success.value = it
        }, {
            error.value = it
        })
    }

    fun success(): LiveData<ResponseServer> {
        return success
    }

    fun error(): LiveData<Throwable> {
        return error
    }

}