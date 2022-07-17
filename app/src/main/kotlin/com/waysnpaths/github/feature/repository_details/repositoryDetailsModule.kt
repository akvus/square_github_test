package com.waysnpaths.github.feature.repository_details

import com.waysnpaths.github.feature.repository_details.data.bookmark.MyDatabaseFactory
import com.waysnpaths.github.feature.repository_details.data.bookmark.BookmarkEntityMapper
import com.waysnpaths.github.feature.repository_details.data.bookmark.BookmarkMapper
import com.waysnpaths.github.feature.repository_details.data.bookmark.DbBookmarkRepository
import com.waysnpaths.github.feature.repository_details.data.bookmark.MyDatabase
import com.waysnpaths.github.feature.repository_details.domain.BookmarkRepository
import com.waysnpaths.github.feature.repository_details.view.GithubRepositoryDetailsViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryDetailsModule = module {
    viewModel { GithubRepositoryDetailsViewModel(get(), get()) }

    single {
        MyDatabaseFactory.make(androidApplication())
    }

    factory { BookmarkMapper() }
    factory { BookmarkEntityMapper() }

    factory {
        val db: MyDatabase = get()
        db.bookmarkDao()
    }

    factory<BookmarkRepository> { DbBookmarkRepository(get(), get(), get()) }
}
