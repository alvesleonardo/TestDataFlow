package com.example.testnetworklibs.di

import com.androidnetworking.AndroidNetworking
import com.example.testnetworklibs.repository.GitHubRepoRepository
import com.example.testnetworklibs.viewModel.GitHubRepositoriesViewModel
import com.jacksonandroidnetworking.JacksonParserFactory
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module


val networkModule = module {
    single { OkHttpClient().newBuilder().build() }
    single(named("network")) { AndroidNetworking.initialize(get(), get()) }
    single { GitHubRepoRepository() }
}

val viewModels = module {
    viewModel { GitHubRepositoriesViewModel(get()) }
}