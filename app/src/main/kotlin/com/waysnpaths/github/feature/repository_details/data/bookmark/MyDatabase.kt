package com.waysnpaths.github.feature.repository_details.data.bookmark

import androidx.room.Database
import androidx.room.RoomDatabase
import com.waysnpaths.github.feature.repository_details.data.bookmark.BookmarkDao
import com.waysnpaths.github.feature.repository_details.data.bookmark.BookmarkEntity

@Database(entities = [BookmarkEntity::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun bookmarkDao(): BookmarkDao
}
