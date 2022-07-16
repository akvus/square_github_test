package com.waysnpaths.github.feature.repository_details.data.stargazer

import com.waysnpaths.github.common.data.remote.SuqareGithubInterface
import com.waysnpaths.github.data.remote.stargazer.StargazerMapper
import com.waysnpaths.github.feature.repository_details.domain.Stargazer
import com.waysnpaths.github.feature.repository_details.domain.StargazerRepository
import io.reactivex.Single

class RemoteStargazerRepository(
    private val squareGitHubInterface: SuqareGithubInterface,
    private val stargazerMapper: StargazerMapper
) : StargazerRepository {
    override fun get(repoName: String): Single<List<Stargazer>> {
        return squareGitHubInterface.getStargazers(repoName)
            .map { stargazerMapper.mapList(it) }
    }
}
