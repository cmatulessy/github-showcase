package com.carlomatulessy.githubshowcase.core.di

import com.carlomatulessy.githubshowcase.detail.di.DetailModule
import com.carlomatulessy.githubshowcase.overview.di.OverviewModule

object KoinModules {
    val modules = listOf(
        NetworkModule.modules,
        OverviewModule.modules,
        DetailModule.modules
    )
}