package com.carlomatulessy.githubshowcase.core.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.carlomatulessy.githubshowcase.core.ui.theme.GitHubShowCaseTheme
import com.carlomatulessy.githubshowcase.overview.ui.screen.OverviewScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitHubShowCaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    OverviewScreen(listOf("Github 1", "Github 2", "Github 3", "Github 4", "Github 5"))
                }
            }
        }
    }
}