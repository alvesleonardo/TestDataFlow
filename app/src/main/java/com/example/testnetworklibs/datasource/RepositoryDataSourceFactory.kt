package com.example.testnetworklibs.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.testnetworklibs.entities.Repository
import com.example.testnetworklibs.repository.GitHubRepoRepository
import com.example.testnetworklibs.ui.RepositoryViewModel
import io.reactivex.disposables.CompositeDisposable

class RepositoryDataSourceFactory(private val gitHubRepoRepository : GitHubRepoRepository, private val disposables: CompositeDisposable): DataSource.Factory<Int, RepositoryViewModel>() {
    val repositoryDataSourceLiveData = MutableLiveData<RepositoryDataSource>()

    override fun create(): DataSource<Int, RepositoryViewModel> {
        return RepositoryDataSource(gitHubRepoRepository, disposables).apply {
            repositoryDataSourceLiveData.postValue(this)
        }
    }


}