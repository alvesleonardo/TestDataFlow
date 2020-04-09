package com.example.testnetworklibs.network

import com.example.testnetworklibs.entities.Repository
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET

interface GithubApi {
    @GET("/repositories")
    fun getRepositories() : Observable<List<Repository>>
}