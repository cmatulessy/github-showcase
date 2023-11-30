package com.carlomatulessy.githubshowcase.overview.data.service

import com.carlomatulessy.githubshowcase.overview.data.model.GithubRepositoryInfoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface GitHubRepositoryApi {

    @GET("repos?page=1&per_page=10") // TODO insert url path
    @Headers("content-type: application/json;charset=UTF-8")
    suspend fun getRepositories(): Response<List<GithubRepositoryInfoResponse>>
}