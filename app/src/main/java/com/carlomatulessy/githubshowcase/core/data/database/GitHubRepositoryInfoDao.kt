package com.carlomatulessy.githubshowcase.core.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GitHubRepositoryInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(gitHubRepositoryInfoEntity: GitHubRepositoryInfoEntity): Long

    @Query("SELECT * FROM GitHubRepositoryInfoEntity")
    fun getGitHubRepositoryInfoList(): List<GitHubRepositoryInfoEntity>
}