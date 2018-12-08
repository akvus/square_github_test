package com.waysnpaths.github.data.remote.stargazer

import com.waysnpaths.github.data.remote.SuqareGitHubInterface
import com.waysnpaths.github.domain.model.Stargazer
import com.waysnpaths.github.domain.repository.StargazerRepository
import io.reactivex.Single

class RemoteStargazerRepository(
    private val squareGitHubInterface: SuqareGitHubInterface,
    private val stargazerMapper: StargazerMapper
) : StargazerRepository {
    override fun get(repoName: String): Single<List<Stargazer>> {
        return squareGitHubInterface.getStargazers(repoName)
            .map { stargazerMapper.mapList(it) }
    }
}