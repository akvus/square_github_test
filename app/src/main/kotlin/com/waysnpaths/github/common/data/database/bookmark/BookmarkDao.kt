package com.waysnpaths.github.data.database.bookmark

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Maybe

@Dao
interface BookmarkDao {
    @Query("SELECT * FROM bookmarkEntity WHERE repoName=:repoName")
    fun get(repoName: String): Maybe<BookmarkEntity?>

    @Insert()
    fun insert(bookmark: BookmarkEntity)

    @Delete()
    fun delete(bookmark: BookmarkEntity)
}