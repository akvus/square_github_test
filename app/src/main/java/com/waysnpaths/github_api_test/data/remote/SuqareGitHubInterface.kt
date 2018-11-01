package com.waysnpaths.github_api_test.data.remote

import com.waysnpaths.github_api_test.data.remote.repo.RepoResponse
import com.waysnpaths.github_api_test.data.remote.stargazer.StargazerResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface SuqareGitHubInterface {
    @GET("orgs/square/repos")
    fun getRepos() : Single<List<RepoResponse>>

    @GET("repos/square/{repoName}/stargazers")
    fun getStargazers(@Path("repoName") repoName: String) : Single<List<StargazerResponse>>
}