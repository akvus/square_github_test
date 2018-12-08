package com.waysnpaths.github.domain.repository

import com.waysnpaths.github.domain.model.Repo
import io.reactivex.Single

interface RepoRepository {
    fun get() : Single<List<Repo>>
}