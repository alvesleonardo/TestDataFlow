package com.example.testnetworklibs

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.MergeAdapter
import com.example.temrecyclertools.ui.adapter.*
import com.example.temrecyclertools.ui.ui.ListDividerItemDecoration
import com.example.temrecyclertools.ui.viewHolder.LoadingRecyclerEntity
import com.example.testnetworklibs.databinding.ActivityMainBinding
import com.example.testnetworklibs.states.RepositoryState
import com.example.testnetworklibs.ui.RepositoryViewModel
import com.example.testnetworklibs.ui.viewHolder.REPOSITORY_LAYOUT_ID
import com.example.testnetworklibs.ui.viewHolder.RepositoryViewHolder
import com.example.testnetworklibs.viewModel.GitHubRepositoriesViewModel
import io.reactivex.rxkotlin.subscribeBy
import io.uniflow.androidx.flow.onStates
import io.uniflow.core.flow.data.UIState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val repositoriesViewModel: GitHubRepositoriesViewModel by viewModel()

    private val loadingAdapter = loadingViewAdapter
    private lateinit var dataAdapter: BaseRecyclerPageViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        bindViews()
        onStates(repositoriesViewModel) { state ->
            Log.e("STATE", state.toString())
            if (state is UIState.Loading) loadingAdapter.addItem(LoadingRecyclerEntity()) else loadingAdapter.clear()
            when (state) {
                is RepositoryState -> dataAdapter.submitList(state.value as PagedList<BaseRecyclerEntity>)
                is UIState.Failed -> state.error?.printStackTrace()
            }
        }

        repositoriesViewModel.repositoryPage.observe(this, Observer{ pageNode ->
            pageNode?.let { node ->
                dataAdapter.submitList(node as PagedList<BaseRecyclerEntity>)
            }
        })
    }

    private fun bindViews() {
        dataAdapter = BaseRecyclerPageViewAdapter(object : ViewHolderFactory {
            override fun getType(recyclerEntity: BaseRecyclerEntity): Int =
                when (recyclerEntity) {
                    is RepositoryViewModel -> REPOSITORY_LAYOUT_ID
                    else -> throw IllegalArgumentException()
                }

            override fun getHolder(viewType: Int, view: View): BaseRecyclerViewHolder<*> =
                when (viewType) {
                    REPOSITORY_LAYOUT_ID -> RepositoryViewHolder(view)
                    else -> throw IllegalArgumentException()
                }
        })
        binding.rvRepositories.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MergeAdapter(dataAdapter, loadingAdapter)
            addItemDecoration(ListDividerItemDecoration(context))
        }
    }
}
