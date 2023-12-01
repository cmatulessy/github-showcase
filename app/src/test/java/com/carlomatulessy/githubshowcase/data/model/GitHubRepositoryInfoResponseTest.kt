package com.carlomatulessy.githubshowcase.data.model

import com.carlomatulessy.githubshowcase.overview.data.model.GithubRepositoryInfoResponse
import com.carlomatulessy.githubshowcase.overview.data.model.OwnerResponse
import com.carlomatulessy.githubshowcase.overview.data.model.toDomain
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class GitHubRepositoryInfoResponseTest {

    @Test
    fun `Given response When toDomain() is called Then return correct domain model`() {
        val response = GithubRepositoryInfoResponse(
            id = 3000,
            name = "JARVIS",
            fullName = "TONY STARK",
            description = "Biljonair",
            private = true,
            owner = OwnerResponse(
                avatarUrl = "FRIDAY",
                url = "url"),
            visibility = "private"
        )

        val result = response.toDomain()

        assertEquals(3000, result.id)
        assertEquals("JARVIS", result.name)
        assertEquals("TONY STARK", result.fullName)
        assertEquals("Biljonair", result.description)
        assertTrue(result.isPrivate)
        assertEquals("FRIDAY", result.avatarUrl)
        assertEquals("url", result.htmlUrl)
        assertEquals("private", result.visibility)

    }
}