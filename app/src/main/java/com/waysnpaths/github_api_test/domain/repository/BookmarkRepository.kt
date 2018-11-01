package com.waysnpaths.github_api_test.domain.repository

import com.waysnpaths.github_api_test.domain.model.Bookmark
import io.reactivex.Completable
import io.reactivex.Maybe

interface BookmarkRepository {
    fun get(repoName: String): Maybe<Bookmark>
    fun add(repoName: Bookmark): Completable
    fun delete(repoName: Bookmark): Completable
}