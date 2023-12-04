package com.carlomatulessy.githubshowcase.core.data.service

import com.carlomatulessy.githubshowcase.core.data.model.GithubRepositoryInfoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface GitHubRepositoryApi {

    @GET("repos") // TODO add pagination?
    @Headers("content-type: application/json;charset=UTF-8")
    suspend fun getRepositories(): Response<List<GithubRepositoryInfoResponse>>
}