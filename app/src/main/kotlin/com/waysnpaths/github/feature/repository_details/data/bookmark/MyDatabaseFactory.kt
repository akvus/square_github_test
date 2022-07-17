package com.waysnpaths.github.feature.repository_details.data.bookmark

import android.content.Context
import androidx.room.Room
import com.waysnpaths.github.Constants

object MyDatabaseFactory {
    fun make(context: Context): MyDatabase = Room.databaseBuilder(
        context,
        MyDatabase::class.java, Constants.databaseName
    ).build()
}
