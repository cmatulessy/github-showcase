package com.carlomatulessy.githubshowcase.core.di

import com.carlomatulessy.githubshowcase.BuildConfig
import com.carlomatulessy.githubshowcase.overview.data.service.GitHubRepositoryApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit

object NetworkModule {
    val modules = module {
        factoryOf(::provideOkHttpClient)
        factoryOf(::provideGitHubRepositoryApi)
        singleOf(::provideRetrofit)
    }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    val contentType = "application/json".toMediaType()
    val json = Json {
        ignoreUnknownKeys = true
    }
    return Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .client(okHttpClient)
        .addConverterFactory(json.asConverterFactory(contentType))
        .build()
}

fun provideOkHttpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    return OkHttpClient()
        .newBuilder()
        .addInterceptor(interceptor)
        .build()
}

fun provideGitHubRepositoryApi(retrofit: Retrofit): GitHubRepositoryApi = retrofit.create(
    GitHubRepositoryApi::class.java)