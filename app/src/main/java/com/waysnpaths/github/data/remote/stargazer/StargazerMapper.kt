package com.waysnpaths.github.data.remote.stargazer

import com.waysnpaths.github.domain.Mapper
import com.waysnpaths.github.domain.model.Stargazer

class StargazerMapper : Mapper<StargazerResponse, Stargazer> {
    override fun map(from: StargazerResponse): Stargazer {
        return Stargazer().apply {
            username = from.login
            avatarUrl = from.avatarUrl
        }
    }
}