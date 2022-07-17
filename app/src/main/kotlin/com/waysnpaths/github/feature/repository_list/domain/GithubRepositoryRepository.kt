package com.waysnpaths.github.feature.repository_list.domain

import io.reactivex.Single

interface GithubRepositoryRepository {
    fun get(): Single<List<GithubRepository>>
}
