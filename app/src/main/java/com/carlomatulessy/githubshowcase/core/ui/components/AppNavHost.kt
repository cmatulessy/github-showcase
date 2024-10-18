package com.carlomatulessy.githubshowcase.core.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavigatorProvider
import androidx.navigation.compose.NavHost
import com.carlomatulessy.githubshowcase.core.ui.navigation.NavigationItem

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Overview.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        builder = NavGraphBuilder(NavigatorProvider(), startDestination, NavigationItem.Overview.route))

    // TODO: https://developer.android.com/codelabs/basic-android-kotlin-compose-navigation#2
}
