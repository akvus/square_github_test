package com.waysnpaths.github.ui.view.main

import com.waysnpaths.github.ui.MyViewModel
import com.waysnpaths.github.ui.routing.ReposListRoute
import com.waysnpaths.github.ui.routing.Router
import com.waysnpaths.github.ui.util.plusAssign

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