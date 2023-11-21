package com.carlomatulessy.githubshowcase.domain.repository

import app.cash.turbine.test
import com.carlomatulessy.githubshowcase.core.data.model.ApiResponse
import com.carlomatulessy.githubshowcase.overview.data.model.GitHubRepositoryResponse
import com.carlomatulessy.githubshowcase.overview.data.repository.GitHubRepositoryImpl
import com.carlomatulessy.githubshowcase.overview.data.service.GitHubRepositoryApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

class GitHubRepositoryTest {

    private val api = mock<GitHubRepositoryApi>()
    private val testDispatcher = StandardTestDispatcher()
    private val repository = GitHubRepositoryImpl(
        gitHubRepositoryApi = api,
        dispatcher = testDispatcher
    )

    @Test
    fun `Given repository When getListOfRepositories is called Then return successful result`() =
        runTest(testDispatcher) {
            val data = mock<GitHubRepositoryResponse>()
            whenever(api.getRepositories()).thenReturn(ApiResponse.Success(data))
            repository.getListOfRepositories().test {
                assertThat(awaitItem()).isInstanceOf(ApiResponse.Success::class.java)
                awaitComplete()
            }
        }
}