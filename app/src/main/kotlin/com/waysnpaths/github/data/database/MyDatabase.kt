package com.waysnpaths.github.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.waysnpaths.github.data.database.bookmark.BookmarkDao
import com.waysnpaths.github.data.database.bookmark.BookmarkEntity

@Database(entities = [BookmarkEntity::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun bookmarkDao(): BookmarkDao
}