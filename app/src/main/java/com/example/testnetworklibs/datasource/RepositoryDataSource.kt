package com.example.testnetworklibs.datasource

import androidx.paging.PageKeyedDataSource
import com.example.testnetworklibs.entities.Repository
import com.example.testnetworklibs.repository.GitHubRepoRepository
import com.example.testnetworklibs.ui.RepositoryViewModel
import io.reactivex.disposables.CompositeDisposable

class RepositoryDataSource(private val gitHubRepoRepository : GitHubRepoRepository, private val disposables: CompositeDisposable) : PageKeyedDataSource<Int, RepositoryViewModel>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, RepositoryViewModel>
    ) {
        disposables.add(
            gitHubRepoRepository.getRepositories(1)
                .subscribe({callback.onResult(it, null, 2)},{it.printStackTrace()})
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, RepositoryViewModel>) {
        disposables.add(
            gitHubRepoRepository.getRepositories(params.key)
                .subscribe({callback.onResult(it, params.key + 1)}, {it.printStackTrace()})
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, RepositoryViewModel>) {
        disposables.add(
            gitHubRepoRepository.getRepositories(params.key)
                .subscribe({callback.onResult(it, params.key - 1)}, {it.printStackTrace()})
        )
    }

}