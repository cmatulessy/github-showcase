package com.carlomatulessy.githubshowcase.core.data.model

sealed interface ApiResponse<out T> {
    data class Success<T>(val data: T): ApiResponse<T>
    data class Failed<T>( val e: Exception): ApiResponse<T>
}