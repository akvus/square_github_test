package com.waysnpaths.github_api_test.ui.view.repoDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.waysnpaths.github_api_test.R
import kotlinx.android.synthetic.main.repos_details_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class RepoDetailsFragment : Fragment() {

    private val viewModel: RepoDetailsViewModel by viewModel()

    private var stargazersAdapter: StargazersAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.repos_details_fragment, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        retainInstance = true

        setUpView()
        initViewModel()
        if (savedInstanceState == null) {
            with(getRepoName()) {
                viewModel.loadStargazers(this)
                viewModel.checkBookmark(this)
            }
        }
    }

    private fun setUpView() {
        stargazersAdapter = StargazersAdapter()
        rvStargazers.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = stargazersAdapter
        }
        btnBookmark.setOnClickListener { viewModel.onBookmark(getRepoName()) }
        btnRemoveBookmark.setOnClickListener { viewModel.onRemoveBookmark(getRepoName())}
    }

    private fun initViewModel() {
        viewModel.getModel().observe(this, Observer(::render))
    }

    private fun render(model: RepoDetailsModel) {
        stargazersAdapter?.submitList(model.stargazers)

        if (model.bookmarked) {
            btnBookmark.visibility = View.GONE
            btnRemoveBookmark.visibility = View.VISIBLE
        } else {
            btnBookmark.visibility = View.VISIBLE
            btnRemoveBookmark.visibility = View.GONE
        }
    }

    private fun getRepoName(): String {
        return arguments!!.getString(nameArgument)!! // crash otherwise
    }

    companion object {
        private const val nameArgument = "name"
        fun newInstance(repoName: String) = RepoDetailsFragment().apply {
            arguments = Bundle().apply {
                putString(nameArgument, repoName)
            }
        }
    }
}