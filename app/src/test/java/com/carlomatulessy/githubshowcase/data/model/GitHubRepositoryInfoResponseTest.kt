package com.carlomatulessy.githubshowcase.data.model

import com.carlomatulessy.githubshowcase.overview.data.model.GitHubRepositoryResponse
import com.carlomatulessy.githubshowcase.overview.data.model.GithubRepositoryInfoResponse
import com.carlomatulessy.githubshowcase.overview.data.model.OwnerResponse
import com.carlomatulessy.githubshowcase.overview.data.model.toDomain
import com.carlomatulessy.githubshowcase.overview.domain.model.GithubRepositoryInfo
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class GitHubRepositoryInfoResponseTest {

    @Test
    fun `Given response When toDomain() is called Then return correct domain model`() {
        val expectedDomainModel = GithubRepositoryInfo(
            name = "JARVIS",
            private = true,
            avatarImage = "FRIDAY",
            visibility = "private"
        )

        val response = GithubRepositoryInfoResponse(
            name = "JARVIS",
            private = true,
            owner = OwnerResponse(avatarUrl = "FRIDAY"),
            visibility = "private"
        )

        val result = GitHubRepositoryResponse(listOf(response)).toDomain()

        with(expectedDomainModel) {
            val responseResult = result.first()
            assertEquals(name, responseResult.name)
            assertTrue(responseResult.private)
            assertEquals(avatarImage, responseResult.avatarImage)
            assertEquals(visibility, responseResult.visibility)
        }
    }
}