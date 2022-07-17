package com.waysnpaths.github.feature.repository_list.data

import com.waysnpaths.github.data.remote.stargazer.StargazerResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface SquareGithubInterface {
    @GET("orgs/square/repos")
    fun getRepos(): Single<List<GithubRepositoryResponse>>

    @GET("repos/square/{repoName}/stargazers")
    fun getStargazers(@Path("repoName") repoName: String): Single<List<StargazerResponse>>
}
