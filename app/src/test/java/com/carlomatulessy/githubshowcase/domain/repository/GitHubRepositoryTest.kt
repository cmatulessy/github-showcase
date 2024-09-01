package com.carlomatulessy.githubshowcase.domain.repository

import app.cash.turbine.test
import com.carlomatulessy.githubshowcase.core.data.model.GithubRepositoryInfoResponse
import com.carlomatulessy.githubshowcase.core.data.model.OwnerResponse
import com.carlomatulessy.githubshowcase.core.data.repository.GitHubRepositoryImpl
import com.carlomatulessy.githubshowcase.core.data.service.GitHubRepositoryApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever
import retrofit2.Response

class GitHubRepositoryTest {

    private val api = mock<GitHubRepositoryApi>()
    private val testDispatcher = StandardTestDispatcher()
    private val repository = GitHubRepositoryImpl(
        gitHubRepositoryApi = api
    )

    @Test
    fun `Given repository When getListOfRepositories is called Then return successful result`() =
        runTest(testDispatcher) {
            val data = GithubRepositoryInfoResponse(
                id = 1,
                name = "name",
                fullName = "fullName",
                description = "description",
                private = true,
                owner = OwnerResponse(
                    avatarUrl = "avatarUrl",
                    htmlUrl = "url"
                ),
                visibility = "visibility",
            )
            whenever(api.getRepositories()).thenReturn(Response.success(listOf(data)))
            repository.getListOfRepositories().test {
                assertThat(awaitItem()).isEqualTo(Response.success(listOf(data)))
                awaitComplete()
            }
        }
}