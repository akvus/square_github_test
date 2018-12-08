package com.waysnpaths.github.data.remote.repo

import com.waysnpaths.github.domain.Mapper
import com.waysnpaths.github.domain.model.Repo

class RepoMapper : Mapper<RepoResponse, Repo> {
    override fun map(from: RepoResponse): Repo {
        return Repo().apply {
            name = from.name
            stargazersCount = from.stargazersCount
        }
    }
}