package com.carlomatulessy.githubshowcase.domain.repository

import com.carlomatulessy.githubshowcase.core.data.model.ApiResponse
import com.carlomatulessy.githubshowcase.overview.data.model.GithubRepositoryInfoResponse
import com.carlomatulessy.githubshowcase.overview.data.repository.GitHubRepositoryImpl
import com.carlomatulessy.githubshowcase.overview.data.service.GitHubRepositoryApi
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class GitHubRepositoryTest {

    private val api = mock<GitHubRepositoryApi>()
    private val testDispatcher = StandardTestDispatcher()
    private val repository = GitHubRepositoryImpl(
        gitHubRepositoryApi = api,
        dispatcher = testDispatcher
    )

    @Test
    fun `Given repository When getListOfRepositories is called Then return successful result`() = runTest {
        val data = mock<GithubRepositoryInfoResponse>()
        whenever(api.getRepositories()).thenReturn(ApiResponse.Success(data))
        val result = repository.getListOfRepositories().collect()
        assertEquals(ApiResponse.Success(data), result)
    }
}