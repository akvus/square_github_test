package com.waysnpaths.github.feature.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.waysnpaths.github.R
import com.waysnpaths.github.common.routing.ReposListRoute
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            viewModel.goToReposList()
        }
        initViewModel()
    }

    private fun initViewModel() {
        with(viewModel) {
            getModel().observe(this@MainActivity) { model ->
                render(model)
            }
            onInit()
        }
    }

    private fun render(model: MainModel) {
        setFragment(model.route.newFragment())
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            if (supportFragmentManager.findFragmentById(R.id.fragmentContainer) == null) {
                add(R.id.fragmentContainer, fragment)
            } else replace(R.id.fragmentContainer, fragment)
        }.commit()
    }

    override fun onBackPressed() {
        if (viewModel.getModel().value?.route !is ReposListRoute) {
            viewModel.goToReposList()
        } else {
            super.onBackPressed()
        }
    }
}
