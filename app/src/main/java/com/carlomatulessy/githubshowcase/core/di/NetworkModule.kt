package com.carlomatulessy.githubshowcase.core.di

import com.carlomatulessy.githubshowcase.BuildConfig
import com.carlomatulessy.githubshowcase.overview.data.service.GitHubRepositoryApi
import okhttp3.OkHttpClient
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    val modules = module {
        factoryOf(::provideOkHttpClient)
        factoryOf(::provideGitHubRepositoryApi)
        singleOf(::provideRetrofit)
    }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BuildConfig.API_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().build()
}

fun provideGitHubRepositoryApi(retrofit: Retrofit): GitHubRepositoryApi = retrofit.create(
    GitHubRepositoryApi::class.java)