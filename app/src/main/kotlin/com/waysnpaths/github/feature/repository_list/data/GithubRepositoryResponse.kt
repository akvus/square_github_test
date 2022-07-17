package com.waysnpaths.github.feature.repository_list.data

import com.google.gson.annotations.SerializedName

class GithubRepositoryResponse {
    @SerializedName("name")
    val name: String = ""

    @SerializedName("stargazers_count")
    val stargazersCount: Int = 0
}
