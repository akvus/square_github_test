package com.waysnpaths.github.feature.main.view

import com.waysnpaths.github.common.layer.view.MyViewModel
import com.waysnpaths.github.common.routing.ReposListRoute
import com.waysnpaths.github.common.routing.Router
import com.waysnpaths.github.common.extension.plusAssign

class MainViewModel(
    private val router: Router
) : MyViewModel<MainModel>() {

    fun onInit() {
        disposables += router.route.subscribe { route ->
            modelLiveData.value = MainModel(route)
        }
    }

    fun goToReposList() {
        router.routeTo(ReposListRoute)
    }
}
