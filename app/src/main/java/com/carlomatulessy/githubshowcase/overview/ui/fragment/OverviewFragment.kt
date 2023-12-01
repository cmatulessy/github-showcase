package com.carlomatulessy.githubshowcase.overview.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.carlomatulessy.githubshowcase.R
import com.carlomatulessy.githubshowcase.databinding.FragmentOverviewBinding
import com.carlomatulessy.githubshowcase.overview.ui.adapter.OverviewAdapter
import com.carlomatulessy.githubshowcase.overview.ui.model.GithubRepositoryInfoUiModel
import com.carlomatulessy.githubshowcase.overview.ui.state.OverviewState
import com.carlomatulessy.githubshowcase.overview.ui.viewmodel.OverviewViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by viewModel()
    private lateinit var binding: FragmentOverviewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOverviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeUi()
    }

    private fun observeUi() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                when (state) {
                    is OverviewState.Error -> showErrorState()
                    is OverviewState.Loading -> showLoadingState()
                    is OverviewState.Overview -> showOverviewState(state.uiModels)
                }
            }
        }
    }

    private fun showLoadingState() = with(binding) {
        stateLoading.root.visibility = View.VISIBLE
        stateError.root.visibility = View.GONE
        stateOverview.visibility = View.GONE
    }

    private fun showErrorState() = with(binding) {
        stateLoading.root.visibility = View.GONE
        stateError.root.visibility = View.VISIBLE
        stateOverview.visibility = View.GONE
    }

    private fun showOverviewState(uiModels: List<GithubRepositoryInfoUiModel>) = with(binding) {
        stateLoading.root.visibility = View.GONE
        stateError.root.visibility = View.GONE
        stateOverview.apply {
            visibility = View.VISIBLE
            adapter = OverviewAdapter(
                uiModels
            ) { onItemClicked(it) }
        }
    }

    private fun onItemClicked(repositoryId: Int) {
        val bundle = bundleOf(REPOSITORY_ID_KEY to repositoryId)
        findNavController().navigate(R.id.action_overviewFragment_to_detailFragment, bundle)
    }

    companion object {
        const val REPOSITORY_ID_KEY = "REPOSITORY_ID_KEY"
    }

}