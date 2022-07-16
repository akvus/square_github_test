package com.waysnpaths.github.data.remote.repo

import com.waysnpaths.github.data.remote.SuqareGitHubInterface
import com.waysnpaths.github.domain.model.Repo
import com.waysnpaths.github.domain.repository.RepoRepository
import io.reactivex.Single

class RemoteRepoRepository(
    private val squareGitHubInterface: SuqareGitHubInterface,
    private val repoMapper: RepoMapper
) : RepoRepository {
    override fun get(): Single<List<Repo>> {
        return squareGitHubInterface.getRepos()
            .map { repo -> repoMapper.mapList(repo) }
    }
}