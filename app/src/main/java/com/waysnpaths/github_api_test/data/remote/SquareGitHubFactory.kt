package com.waysnpaths.github_api_test.data.remote

import com.waysnpaths.github_api_test.MyContract
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object SquareGitHubFactory {
    fun make(): SuqareGitHubInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl(MyContract.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return retrofit.create<SuqareGitHubInterface>(SuqareGitHubInterface::class.java)
    }
}