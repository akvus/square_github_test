package com.waysnpaths.github_api_test.ui.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.waysnpaths.github_api_test.R
import com.waysnpaths.github_api_test.ui.view.repoDetails.RepoDetailsFragment
import com.waysnpaths.github_api_test.ui.view.reposList.ReposListFragment
import com.waysnpaths.github_api_test.ui.routing.RepoDetailsRoute
import com.waysnpaths.github_api_test.ui.routing.ReposListRoute
import com.waysnpaths.github_api_test.ui.routing.Route
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    private var firstRoute: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            viewModel.goToReposList()
        } else {
            firstRoute = false
        }
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.getModel().observe(this, Observer { model ->
            render(model)
        })
        viewModel.onInit()
    }

    private fun render(model: MainModel) {
        setFragment(findFragment(model.route))
    }

    private fun findFragment(route: Route): Fragment {
        return when (route) {
            is ReposListRoute -> ReposListFragment.newInstance()
            is RepoDetailsRoute -> RepoDetailsFragment.newInstance(route.name)
        }
    }

    private fun setFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        if (firstRoute) {
            transaction.add(R.id.fragmentContainer, fragment)
            firstRoute = false
        } else transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()
    }

    override fun onBackPressed() {
        if (viewModel.getModel().value?.route !is ReposListRoute) {
            viewModel.goToReposList()
        } else {
            super.onBackPressed()
        }
    }
}
