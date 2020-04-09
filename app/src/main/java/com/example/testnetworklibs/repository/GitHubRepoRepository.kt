package com.example.testnetworklibs.repository

import com.example.testnetworklibs.entities.Repository
import com.example.testnetworklibs.network.GithubApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class GitHubRepoRepository(private val service : GithubApi) {
    fun getRepositories(): Observable<List<Repository>> {
        return service.getRepositories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}

