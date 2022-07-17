package com.waysnpaths.github.feature.repository_list.data

import com.google.gson.annotations.SerializedName

class GithubRepositoryResponse {
    @SerializedName("name")
    var name: String = ""

    @SerializedName("stargazers_count")
    var stargazersCount: Int = 0
}
