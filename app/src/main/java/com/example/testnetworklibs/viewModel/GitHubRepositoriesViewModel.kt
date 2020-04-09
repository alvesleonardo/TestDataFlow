package com.example.testnetworklibs.viewModel

import com.example.testnetworklibs.repository.GitHubRepoRepository
import com.example.testnetworklibs.rxAndroid.toDataFlow
import com.example.testnetworklibs.states.RepositoryState
import com.example.testnetworklibs.ui.RepositoryViewModel
import io.uniflow.androidx.flow.AndroidDataFlow
import java.util.concurrent.TimeUnit

class GitHubRepositoriesViewModel(private val gitHubRepoRepository: GitHubRepoRepository) :
    AndroidDataFlow() {
    fun getRepositories() = action {
        gitHubRepoRepository.getRepositories()
            .delay(2, TimeUnit.SECONDS)
            .map { it.map {RepositoryViewModel(it.fullName?:"")} }
            .toDataFlow(
                RepositoryState::class.java,
                this@GitHubRepositoriesViewModel as AndroidDataFlow
            )
    }
}
