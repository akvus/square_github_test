package com.waysnpaths.github.common.layer.data

interface Mapper<From, To> {
    fun map(from: From): To

    fun mapList(from: List<From>): List<To> = mutableListOf<To>().also { list ->
        from.forEach { list.add(map(it)) }
    }
}
