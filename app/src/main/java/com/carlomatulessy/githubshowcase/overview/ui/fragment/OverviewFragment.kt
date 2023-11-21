package com.carlomatulessy.githubshowcase.overview.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.carlomatulessy.githubshowcase.databinding.FragmentOverviewBinding
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
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.uiState.collect { state ->
                    when(state) {
                        is OverviewState.Error -> showErrorState()
                        is OverviewState.Loading -> showLoadingState()
                        is OverviewState.Overview -> showOverviewState()
                    }
                }
            }
        }
    }

    private fun showLoadingState() = with(binding) {
        stateLoading.root.visibility = View.VISIBLE
        stateError.root.visibility= View.GONE
        stateOverview.visibility = View.GONE
    }

    private fun showErrorState() = with(binding) {
        stateLoading.root.visibility = View.GONE
        stateError.root.visibility= View.VISIBLE
        stateOverview.visibility = View.GONE
    }

    private fun showOverviewState() = with(binding) {
        stateLoading.root.visibility = View.GONE
        stateError.root.visibility= View.GONE
        stateOverview.apply {
            visibility = View.VISIBLE
            //adapter = OverviewAdapter(uiModel.)
        }
    }
}