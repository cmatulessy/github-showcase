package com.carlomatulessy.githubshowcase.overview.data.service

import com.carlomatulessy.githubshowcase.core.data.model.ApiResponse
import com.carlomatulessy.githubshowcase.overview.data.model.GitHubRepositoryResponse
import com.carlomatulessy.githubshowcase.overview.data.model.GithubRepositoryInfoResponse
import com.carlomatulessy.githubshowcase.overview.domain.model.GithubRepositoryInfo
import retrofit2.http.GET
import retrofit2.http.Headers

interface GitHubRepositoryApi {

    @GET("") // TODO insert url path
    @Headers("content-type: application/json;charset=UTF-8")
    suspend fun getRepositories(): ApiResponse<GitHubRepositoryResponse>
}