package com.waysnpaths.github.feature.repository_details.data.bookmark

import com.waysnpaths.github.feature.repository_details.domain.Bookmark
import com.waysnpaths.github.feature.repository_details.domain.BookmarkRepository
import io.reactivex.Completable
import io.reactivex.Maybe

class DbBookmarkRepository(
    private val bookmarkDao: BookmarkDao,
    private val bookmarkMapper: BookmarkMapper,
    private val bookmarkEntityMapper: BookmarkEntityMapper
) : BookmarkRepository {
    override fun get(repoName: String): Maybe<Bookmark> = bookmarkDao.get(repoName)
        .map { bookmarkMapper.map(it) }

    override fun add(repoName: Bookmark): Completable {
        // todo this is done due to when I tried Dao to return Completable build was failing in generated code
        return Completable.fromCallable { bookmarkDao.insert(bookmarkEntityMapper.map(repoName)) }
    }

    override fun delete(repoName: Bookmark): Completable {
        // todo this is done due to when I tried Dao to return Completable build was failing in generated code
        return Completable.fromCallable { bookmarkDao.delete(bookmarkEntityMapper.map(repoName)) }
    }

}
