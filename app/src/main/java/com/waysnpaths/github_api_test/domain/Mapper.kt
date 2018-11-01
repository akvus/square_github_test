package com.waysnpaths.github_api_test.domain

interface Mapper<From, To> {
    fun map(from: From): To

    fun mapList(from: List<From>): List<To> {
        return mutableListOf<To>().also { list ->
            from.forEach { list.add(map(it)) }
        }
    }
}