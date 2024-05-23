package com.carlomatulessy.githubshowcase.core.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carlomatulessy.githubshowcase.core.ui.theme.GitHubShowCaseTheme

@Composable
fun ListItem(name: String, modifier: Modifier = Modifier) {
    Column {
        Row {
            Text(
                text = name,
                modifier = Modifier
                    .padding(all = 8.dp)
            )
        }
        Divider(modifier = Modifier.height(1.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ListItemPreview() {
    GitHubShowCaseTheme {
        ListItem(name = "Github Repo")
    }
}