package com.waysnpaths.github.feature.repository_details.domain

import io.reactivex.Completable
import io.reactivex.Maybe

interface BookmarkRepository {
    fun get(repoName: String): Maybe<Bookmark>
    fun add(repoName: Bookmark): Completable
    fun delete(repoName: Bookmark): Completable
}
