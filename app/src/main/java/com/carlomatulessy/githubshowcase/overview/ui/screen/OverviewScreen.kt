package com.carlomatulessy.githubshowcase.overview.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.carlomatulessy.githubshowcase.core.ui.components.ListItem
import com.carlomatulessy.githubshowcase.core.ui.theme.GitHubShowCaseTheme

@Composable
fun OverviewScreen(githubNames: List<String>) {
    GitHubShowCaseTheme {
        LazyColumn {
            items(githubNames) {name ->
                ListItem(name = name)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OverviewScreenPreview() {
    OverviewScreen(githubNames = listOf("Github 1", "Github 2", "Github 3", "Github 4", "Github 5"))
}