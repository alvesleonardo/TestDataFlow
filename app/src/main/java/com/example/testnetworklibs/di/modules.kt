package com.example.testnetworklibs.di

import com.example.testnetworklibs.network.GithubApi
import com.example.testnetworklibs.repository.GitHubRepoRepository
import com.example.testnetworklibs.viewModel.GitHubRepositoriesViewModel
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory

val networkModule = module {
    single { OkHttpClient.Builder().build() }
    single { RetrofitBuilder.createWebService<GithubApi>(get(), "https://api.github.com/") }
    single { GitHubRepoRepository(get()) }
}

val viewModels = module {
    viewModel { GitHubRepositoriesViewModel(get()) }
}

object RetrofitBuilder {
    inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
        return retrofit.create(T::class.java)
    }
}