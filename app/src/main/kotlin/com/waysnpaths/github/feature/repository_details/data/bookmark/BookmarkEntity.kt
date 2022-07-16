package com.waysnpaths.github.feature.repository_details.data.bookmark

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BookmarkEntity(
    @PrimaryKey()
    @ColumnInfo(name = "repoName")
    var repoName: String = ""
)
