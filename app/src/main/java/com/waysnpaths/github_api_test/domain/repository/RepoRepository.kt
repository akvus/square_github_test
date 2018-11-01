package com.waysnpaths.github_api_test.domain.repository

import com.waysnpaths.github_api_test.domain.model.Repo
import io.reactivex.Single

interface RepoRepository {
    fun get() : Single<List<Repo>>
}