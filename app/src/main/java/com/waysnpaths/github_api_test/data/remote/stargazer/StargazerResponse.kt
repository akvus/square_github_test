package com.waysnpaths.github_api_test.data.remote.stargazer

import com.google.gson.annotations.SerializedName

class StargazerResponse {
    @SerializedName("login")
    var login: String = ""

    @SerializedName("avatar_url")
    var avatarUrl: String = ""

}