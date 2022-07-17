package com.waysnpaths.github.feature.repository_list.data

import com.waysnpaths.github.MyContract
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object SquareGithubFactory {
    fun make(): SquareGithubInterface {
        val retrofit = Retrofit.Builder()
            .baseUrl(MyContract.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return retrofit.create(SquareGithubInterface::class.java)
    }
}
