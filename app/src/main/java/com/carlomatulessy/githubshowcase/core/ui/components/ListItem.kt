package com.carlomatulessy.githubshowcase.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carlomatulessy.githubshowcase.R
import com.carlomatulessy.githubshowcase.core.ui.theme.GitHubShowCaseTheme

@Composable
fun ListItem(
    name: String,
    visibility: String,
    isPrivate: Boolean,
    modifier: Modifier = Modifier
) {
    val image = painterResource(id = R.drawable.ic_unknown)

    Column {
        Row(
            modifier = Modifier
                .padding(all = 8.dp)
        ) {

            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = image,
                    contentDescription = null
                )
            }

            Column {
                Text(
                    text = name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = visibility,
                    fontSize = 12.sp
                )

                Text(
                    text = "Is private: $isPrivate",
                    fontSize = 12.sp
                )
            }

        }
        Divider(modifier = Modifier.height(1.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ListItemPreview() {
    GitHubShowCaseTheme {
        ListItem(
            name = "Github Repo",
            visibility = "Visibility: Public",
            isPrivate = false
        )
    }
}