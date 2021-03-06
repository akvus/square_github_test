package com.waysnpaths.github.ui.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.waysnpaths.github.R
import com.waysnpaths.github.ui.routing.ReposListRoute
import org.koin.android.viewmodel.ext.android.viewModel

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
        viewModel.getModel().observe(this, Observer { model ->
            render(model)
        })
        viewModel.onInit()
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
