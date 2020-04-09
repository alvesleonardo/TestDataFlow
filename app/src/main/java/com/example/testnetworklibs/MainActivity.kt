package com.example.testnetworklibs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.testnetworklibs.states.RepositoryState
import com.example.testnetworklibs.viewModel.GitHubRepositoriesViewModel
import io.uniflow.androidx.flow.onStates
import io.uniflow.core.flow.data.UIState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val repositoriesViewModel : GitHubRepositoriesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onStates(repositoriesViewModel) {state ->
            when(state){
                is UIState.Loading -> Log.e("LOADING", "true")
                is RepositoryState -> Log.e("Loaded", state.value.size.toString())
                is UIState.Failed -> state.error?.printStackTrace()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        repositoriesViewModel.getRepositories()
    }
}
