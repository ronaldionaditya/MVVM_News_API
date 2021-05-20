package com.mobile.mvvmnewsapi.repository

interface RepoService {
    fun success(message:String)

    fun error(message: String)
}