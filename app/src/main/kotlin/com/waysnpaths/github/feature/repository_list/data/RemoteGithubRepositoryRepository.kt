package com.waysnpaths.github.feature.repository_list.data

import com.waysnpaths.github.feature.repository_list.domain.GithubRepository
import com.waysnpaths.github.feature.repository_list.domain.GithubRepositoryRepository
import io.reactivex.Single

class RemoteGithubRepositoryRepository(
    private val squareGithubInterface: SquareGithubInterface,
    private val githubRepositoryMapper: GithubRepositoryMapper
) : GithubRepositoryRepository {
    override fun get(): Single<List<GithubRepository>> = squareGithubInterface.getRepos()
        .map { repo -> githubRepositoryMapper.mapList(repo) }
}
