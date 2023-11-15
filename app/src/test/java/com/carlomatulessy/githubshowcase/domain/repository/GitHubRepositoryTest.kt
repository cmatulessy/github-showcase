package com.carlomatulessy.githubshowcase.domain.repository

import com.carlomatulessy.githubshowcase.overview.data.repository.GitHubRepositoryImpl
import com.carlomatulessy.githubshowcase.overview.data.service.GitHubRepositoryApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mockito.mock

class GitHubRepositoryTest {

    private val api = mock<GitHubRepositoryApi>()
    private val testDispatcher = StandardTestDispatcher()
    private val repository = GitHubRepositoryImpl(
        gitHubRepositoryApi = api,
        dispatcher = testDispatcher
    )

    @Test
    fun `Given repository When getListOfRepositories is called Then return successful result`() = runTest {

    }
}