package com.carlomatulessy.githubshowcase.core.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GitHubRepositoryInfoEntity::class], version = 1, exportSchema = false)
abstract class GitHubRepositoryInfoDatabase: RoomDatabase() {
    companion object {
        private var instance: GitHubRepositoryInfoDatabase? = null
        fun getInstance(context: Context) =
            instance?.let {
                it
            } ?: run {
                synchronized(GitHubRepositoryInfoDatabase::class) {
                    Room
                        .databaseBuilder(
                            context.applicationContext,
                            GitHubRepositoryInfoDatabase::class.java, "githubrepositoryinfo.db"
                        )
                        .build()
                }
            }
    }
}