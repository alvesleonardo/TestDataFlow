package com.example.testnetworklibs.repository

import android.util.Log
import com.example.testnetworklibs.entities.Repository
import com.example.testnetworklibs.network.GithubApi
import com.example.testnetworklibs.ui.RepositoryViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class GitHubRepoRepository(private val service : GithubApi) {
    fun getRepositories(page: Int): Observable<List<RepositoryViewModel>> {
        return service.getCharacters(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.results.orEmpty() }
            .doOnNext { Log.e("REturned", it.size.toString()) }
            .map { it.map { RepositoryViewModel(it.name?:"") } }
            .doOnNext { Log.e("Maped", it.size.toString()) }
    }
}

