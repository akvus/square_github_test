package com.waysnpaths.github.feature.repository_list.data.repo

import com.waysnpaths.github.common.data.remote.SuqareGithubInterface
import com.waysnpaths.github.feature.repository_list.domain.Repo
import com.waysnpaths.github.feature.repository_list.domain.RepoRepository
import io.reactivex.Single

class RemoteRepoRepository(
    private val squareGitHubInterface: SuqareGithubInterface,
    private val repoMapper: RepoMapper
) : RepoRepository {
    override fun get(): Single<List<Repo>> {
        return squareGitHubInterface.getRepos()
            .map { repo -> repoMapper.mapList(repo) }
    }
}
