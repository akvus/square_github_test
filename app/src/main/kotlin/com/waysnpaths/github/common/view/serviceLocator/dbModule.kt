package com.waysnpaths.github.common.view.serviceLocator

import com.waysnpaths.github.common.data.database.MyDatabase
import com.waysnpaths.github.common.data.database.MyDatabaseFactory
import com.waysnpaths.github.feature.repository_details.data.bookmark.DbBookmarkRepository
import com.waysnpaths.github.feature.repository_details.data.bookmark.BookmarkEntityMapper
import com.waysnpaths.github.feature.repository_details.data.bookmark.BookmarkMapper
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dbModule = module {
    single {
        MyDatabaseFactory.make(androidApplication())
    }

    factory { BookmarkMapper() }
    factory { BookmarkEntityMapper() }

    factory {
        val db: MyDatabase = get()
        db.bookmarkDao()
    }

    factory { DbBookmarkRepository(get(), get(), get()) }
}
