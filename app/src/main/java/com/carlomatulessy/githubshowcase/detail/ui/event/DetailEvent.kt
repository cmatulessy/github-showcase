package com.carlomatulessy.githubshowcase.detail.ui.event

sealed interface DetailEvent {
    data class LoadInfoForRepositoryWithId(val id: Int?): DetailEvent
}