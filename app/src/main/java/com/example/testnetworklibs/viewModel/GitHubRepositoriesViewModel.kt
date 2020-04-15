package com.example.testnetworklibs.viewModel

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.example.testnetworklibs.datasource.RepositoryDataSourceFactory
import com.example.testnetworklibs.repository.GitHubRepoRepository
import com.example.testnetworklibs.rxAndroid.toDataFlow
import com.example.testnetworklibs.states.RepositoryState
import com.example.testnetworklibs.ui.RepositoryViewModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import io.uniflow.androidx.flow.AndroidDataFlow
import io.uniflow.core.flow.data.UIState
import java.util.concurrent.Executors

class GitHubRepositoriesViewModel(private val gitHubRepoRepository: GitHubRepoRepository) :
    AndroidDataFlow() {
    fun setState(state: UIState) {
        action { setState { state } }
    }

    var repositoryPage: LiveData<PagedList<RepositoryViewModel>>

    //    private var list: Observable<PagedList<RepositoryViewModel>>
    private val compositeDisposable = CompositeDisposable()
    private val pageSize = 20

    private val sourceFactory: RepositoryDataSourceFactory
    private val executor = Executors.newFixedThreadPool(4);

    init {
        sourceFactory = RepositoryDataSourceFactory(gitHubRepoRepository, compositeDisposable)
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setEnablePlaceholders(false)
            .setPrefetchDistance(20)
            .build()
        repositoryPage = LivePagedListBuilder(sourceFactory, config)
            .setFetchExecutor(executor).build()
//        repositoryPage.observeForever { pageNode ->
//            pageNode?.let { node ->
//                Log.e("Repository", node.size.toString())
//                action {
//                    setState {
//                        RepositoryState(node)
//                    }
//                }
//            }
//        }
    }
}
