package com.waysnpaths.github.data.database

import android.content.Context
import androidx.room.Room
import com.waysnpaths.github.MyContract

object MyDatabaseFactory {
    fun make(context: Context): MyDatabase {
        return Room.databaseBuilder(
            context,
            MyDatabase::class.java, MyContract.databaseName
        ).build()
    }
}