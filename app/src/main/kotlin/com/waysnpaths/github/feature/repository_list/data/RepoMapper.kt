package com.waysnpaths.github.feature.repository_list.data

import com.waysnpaths.github.common.layer.data.Mapper
import com.waysnpaths.github.feature.repository_list.domain.Repo

class RepoMapper : Mapper<RepoResponse, Repo> {
    override fun map(from: RepoResponse): Repo {
        return Repo().apply {
            name = from.name
            stargazersCount = from.stargazersCount
        }
    }
}
