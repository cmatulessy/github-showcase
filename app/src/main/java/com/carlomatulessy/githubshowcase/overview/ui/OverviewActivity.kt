package com.carlomatulessy.githubshowcase.overview.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.carlomatulessy.githubshowcase.overview.domain.model.GithubRepositoryInfo
import com.carlomatulessy.githubshowcase.overview.ui.theme.GitHubShowCaseTheme
import com.carlomatulessy.githubshowcase.overview.ui.viewmodel.OverviewViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class OverviewActivity : ComponentActivity() {

    private val viewModel: OverviewViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitHubShowCaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Overview()
                }
            }
        }
    }
}

@Composable
fun Overview() {
    LazyColumn(Modifier.fillMaxSize()) {
        items()
    }
}

@Composable
fun ListItem(uiModel: GithubRepositoryInfo, modifier: Modifier) {
    Row(modifier.fillMaxWidth()) {
        Text(text = uiModel.name)
        //TODO add other stuff
    }
}

@Preview(showBackground = true)
@Composable
fun OverviewPreview() {
    GitHubShowCaseTheme {
        Overview()
    }
}