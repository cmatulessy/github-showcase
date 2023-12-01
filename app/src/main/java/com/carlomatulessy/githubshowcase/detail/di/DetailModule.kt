package com.carlomatulessy.githubshowcase.detail.di

import com.carlomatulessy.githubshowcase.detail.domain.usecase.GetDetailUseCase
import com.carlomatulessy.githubshowcase.detail.ui.viewmodel.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

object DetailModule {
    val modules = module {
        factoryOf(::GetDetailUseCase)

        viewModel {
            DetailViewModel(
                useCase = get() as GetDetailUseCase
            )
        }
    }
}