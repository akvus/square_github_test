package com.waysnpaths.github.common.routing

import io.reactivex.subjects.BehaviorSubject

object Router {
    val route by lazy { BehaviorSubject.create<Route>() }

    fun routeTo(route: Route) {
        Router.route.onNext(route)
    }
}
