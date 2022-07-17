package com.waysnpaths.github.feature.repository_details.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.waysnpaths.github.databinding.ReposDetailsFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GithubRepositoryDetailsFragment : Fragment() {

    private val viewModel: GithubRepositoryDetailsViewModel by viewModel()

    private var stargazersAdapter: StargazersAdapter? = null

    private var _binding: ReposDetailsFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ReposDetailsFragmentBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        binding.rvStargazers.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = stargazersAdapter
        }
        binding.btnBookmark.setOnClickListener { viewModel.onBookmark(getRepoName()) }
        binding.btnRemoveBookmark.setOnClickListener { viewModel.onRemoveBookmark(getRepoName()) }
    }

    private fun initViewModel() {
        viewModel.getModel().observe(viewLifecycleOwner, Observer(::render))
    }

    private fun render(model: GithubRepositoryDetailsModel) {
        stargazersAdapter?.submitList(model.stargazers)

        if (model.bookmarked) {
            binding.btnBookmark.visibility = View.GONE
            binding.btnRemoveBookmark.visibility = View.VISIBLE
        } else {
            binding.btnBookmark.visibility = View.VISIBLE
            binding.btnRemoveBookmark.visibility = View.GONE
        }
    }

    private fun getRepoName(): String {
        return arguments!!.getString(nameArgument)!! // crash otherwise
    }

    companion object {
        private const val nameArgument = "name"
        fun newInstance(repoName: String) = GithubRepositoryDetailsFragment().apply {
            arguments = Bundle().apply {
                putString(nameArgument, repoName)
            }
        }
    }
}
