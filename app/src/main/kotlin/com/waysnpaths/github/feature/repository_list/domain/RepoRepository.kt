package com.waysnpaths.github.feature.repository_list.domain

import io.reactivex.Single

interface RepoRepository {
    fun get(): Single<List<Repo>>
}
