package com.waysnpaths.github_api_test.data.database.bookmark

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BookmarkEntity(
    @PrimaryKey()
    @ColumnInfo(name = "repoName")
    var repoName: String = ""
)