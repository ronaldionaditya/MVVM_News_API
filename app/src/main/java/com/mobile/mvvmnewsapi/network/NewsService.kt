package com.mobile.mvvmnewsapi.network

import com.mobile.mvvmnewsapi.model.ResponseServer
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

//todo 4
interface NewsService {

    @GET("everything?q=football&from=2021-02-19&sortBy=publishedAt&apiKey=e34d7f63faef420b861e83bda168ba83")
    fun getData(): Flowable<ResponseServer>
}