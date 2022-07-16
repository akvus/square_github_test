package com.waysnpaths.github.ui.routing

import io.reactivex.subjects.BehaviorSubject

object Router {
    val route by lazy { BehaviorSubject.create<Route>() }

    fun routeTo(route: Route) {
        this.route.onNext(route)
    }
}