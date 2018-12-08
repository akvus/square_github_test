package com.waysnpaths.github.ui.serviceLocator

import com.waysnpaths.github.data.database.MyDatabase
import com.waysnpaths.github.data.database.MyDatabaseFactory
import com.waysnpaths.github.data.database.bookmark.BookmarkEntityMapper
import com.waysnpaths.github.data.database.bookmark.BookmarkMapper
import com.waysnpaths.github.data.database.bookmark.DbBookmarkRepository
import com.waysnpaths.github.domain.repository.BookmarkRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val dbModule = module {
    single {
        MyDatabaseFactory.make(androidApplication())
    }

    factory { BookmarkMapper() }
    factory { BookmarkEntityMapper() }

    factory {
        val db : MyDatabase = get()
        db.bookmarkDao()
    }

    factory { DbBookmarkRepository(get(), get(), get()) as BookmarkRepository }
}