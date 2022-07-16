package com.waysnpaths.github.common.data.remote

import com.waysnpaths.github.feature.repository_list.data.repo.RepoResponse
import com.waysnpaths.github.data.remote.stargazer.StargazerResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface SuqareGithubInterface {
    @GET("orgs/square/repos")
    fun getRepos(): Single<List<RepoResponse>>

    @GET("repos/square/{repoName}/stargazers")
    fun getStargazers(@Path("repoName") repoName: String): Single<List<StargazerResponse>>
}
