package com.waysnpaths.github.feature.repository_list.data.repo

import com.google.gson.annotations.SerializedName

class RepoResponse {
    @SerializedName("name")
    var name: String = ""

    @SerializedName("stargazers_count")
    var stargazersCount: Int = 0
}
