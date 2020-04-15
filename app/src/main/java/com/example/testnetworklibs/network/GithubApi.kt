package com.example.testnetworklibs.network

import com.example.testnetworklibs.entities.Repository
import com.example.testnetworklibs.entity.CharactersResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {
//    @GET("/repositories")
//    fun getRepositories(@Query("page") page: Int, @Query("per_page") perPage: Int) : Observable<List<Repository>>

    @GET("character")
    fun getCharacters(@Query("page") page: Int) : Observable<CharactersResponse>
}