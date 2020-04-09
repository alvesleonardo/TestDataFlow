package com.example.testnetworklibs.repository

import com.androidnetworking.common.Priority
import com.example.testnetworklibs.entities.Repository
import com.google.gson.reflect.TypeToken
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class GitHubRepoRepository {
    fun getRepositories(): Observable<List<Repository>> {
        class Result : TypeToken<List<Repository>>()
        return Rx2AndroidNetworking.get("https://api.github.com/repositories")
            .setPriority(Priority.LOW)
            .build()
            .getObjectObservable(Result().rawType)
            .map { it as List<Repository>}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}

