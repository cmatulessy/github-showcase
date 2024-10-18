package com.carlomatulessy.githubshowcase.core.ui.navigation

enum class Screen {
    OVERVIEW,
    DETAIL
}

sealed class NavigationItem(val route: String) {
    data object Overview : NavigationItem(Screen.OVERVIEW.name)
    data object Detail : NavigationItem(Screen.DETAIL.name)
}