package com.example.testnetworklibs.viewModel

import com.example.testnetworklibs.entities.Repository
import com.example.testnetworklibs.repository.GitHubRepoRepository
import com.example.testnetworklibs.rxAndroid.toDataFlow
import com.example.testnetworklibs.states.RepositoryState
import com.example.testnetworklibs.states.ResultState
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import io.uniflow.androidx.flow.AndroidDataFlow
import io.uniflow.core.flow.data.UIState

class GitHubRepositoriesViewModel(private val gitHubRepoRepository: GitHubRepoRepository) :
    AndroidDataFlow() {
    fun getRepositories() = action {
        gitHubRepoRepository.getRepositories()
            .zipWith(gitHubRepoRepository.getRepositories(), BiFunction { t1:List<Repository>, t2:List<Repository> ->
                val response = ArrayList<Repository>()
                response.addAll(t1)
                response.addAll(t2)
                response.toList()
            })
            .toDataFlow(
                RepositoryState::class.java,
                this@GitHubRepositoriesViewModel as AndroidDataFlow
            )
    }
}
