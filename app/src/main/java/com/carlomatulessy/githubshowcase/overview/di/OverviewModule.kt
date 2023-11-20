package com.carlomatulessy.githubshowcase.overview.di

import com.carlomatulessy.githubshowcase.overview.domain.usecase.GetOverviewUseCase
import com.carlomatulessy.githubshowcase.overview.ui.viewmodel.OverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

object OverviewModule {

    val modules = module {
        factoryOf(::GetOverviewUseCase)

        viewModel {
            OverviewViewModel(
                useCase = get() as GetOverviewUseCase
            )
        }
    }
}