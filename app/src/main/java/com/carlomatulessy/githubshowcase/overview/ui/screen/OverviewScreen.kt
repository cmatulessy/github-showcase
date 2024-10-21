package com.carlomatulessy.githubshowcase.overview.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.carlomatulessy.githubshowcase.core.ui.components.ListItem
import com.carlomatulessy.githubshowcase.core.ui.theme.GitHubShowCaseTheme
import com.carlomatulessy.githubshowcase.overview.ui.viewmodel.OverviewViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun OverviewScreen(
    viewModel: OverviewViewModel = koinViewModel()
) {

    GitHubShowCaseTheme {
        LazyColumn {
            items() { name ->
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