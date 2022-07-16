package com.waysnpaths.github.feature.repository_list.data.repo

import com.waysnpaths.github.common.data.Mapper
import com.waysnpaths.github.feature.repository_list.domain.Repo

class RepoMapper : Mapper<RepoResponse, Repo> {
    override fun map(from: RepoResponse): Repo {
        return Repo().apply {
            name = from.name
            stargazersCount = from.stargazersCount
        }
    }
}
