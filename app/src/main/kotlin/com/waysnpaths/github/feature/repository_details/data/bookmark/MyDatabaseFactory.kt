package com.waysnpaths.github.feature.repository_details.data.bookmark

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
