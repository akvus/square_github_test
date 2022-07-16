package com.waysnpaths.github.feature.repository_list.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.waysnpaths.github.R
import com.waysnpaths.github.common.view.util.plusAssign
import io.reactivex.disposables.CompositeDisposable

// todo maybe creating VM, init VM and rendering model could be abstracted
class ReposListFragment : Fragment() {
    private var disposables = CompositeDisposable()

    private val viewModel: ReposListViewModel by viewModel()

    private var reposAdapter: ReposListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.repos_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        retainInstance = true

        setUpView()
        initViewModel()
        if (savedInstanceState == null)
            viewModel.loadRepos()
    }

    private fun setUpView() {
        reposAdapter = ReposListAdapter()
        disposables += reposAdapter?.onClickSubject?.subscribe { viewModel.routeToDetails(it) }
        rvRepos.layoutManager = LinearLayoutManager(context)
        rvRepos.adapter = reposAdapter
    }

    private fun initViewModel() {
        viewModel.getModel().observe(this, Observer(::render))
    }

    private fun render(model: ReposListModel) {
        reposAdapter?.submitList(model.repos)
        model.message?.let {
            it.getContentIfNotHandled()?.let { snack(it) }
        }
    }

    private fun snack(text: String) {
        Snackbar.make(rootView, text, Snackbar.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        disposables.clear()
    }

    companion object {
        fun newInstance() = ReposListFragment()
    }
}
