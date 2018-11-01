package com.waysnpaths.github_api_test.data.database

import android.content.Context
import androidx.room.Room
import com.waysnpaths.github_api_test.MyContract

object MyDatabaseFactory {
    fun make(context: Context): MyDatabase {
        return Room.databaseBuilder(
            context,
            MyDatabase::class.java, MyContract.databaseName
        ).build()
    }
}