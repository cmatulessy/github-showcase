package com.carlomatulessy.githubshowcase.overview.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.carlomatulessy.githubshowcase.core.ui.components.ListItem
import com.carlomatulessy.githubshowcase.core.ui.theme.GitHubShowCaseTheme
import com.carlomatulessy.githubshowcase.overview.ui.viewmodel.OverviewViewModel
import org.koin.core.context.GlobalContext.get

@Composable
fun OverviewScreen() {
    val viewModel = getViewModel()

    GitHubShowCaseTheme {
        LazyColumn {
            items(githubNames) { name ->
                ListItem(name = name)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OverviewScreenPreview() {
    OverviewScreen()
}