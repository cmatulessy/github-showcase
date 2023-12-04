package com.carlomatulessy.githubshowcase.detail.ui.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.carlomatulessy.githubshowcase.R
import com.carlomatulessy.githubshowcase.databinding.FragmentDetailBinding
import com.carlomatulessy.githubshowcase.detail.ui.event.DetailEvent
import com.carlomatulessy.githubshowcase.detail.ui.model.DetailUiModel
import com.carlomatulessy.githubshowcase.detail.ui.state.DetailState
import com.carlomatulessy.githubshowcase.detail.ui.viewmodel.DetailViewModel
import com.carlomatulessy.githubshowcase.overview.ui.fragment.OverviewFragment.Companion.REPOSITORY_ID_KEY
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    private val viewModel: DetailViewModel by viewModel()
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeUi()
        requestRepositoryData()
    }

    private fun observeUi() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                when (state) {
                    is DetailState.Error -> showErrorState()
                    is DetailState.Loading -> showLoadingState()
                    is DetailState.Overview -> showOverviewState(state.uiModel)
                }
            }
        }
    }

    private fun requestRepositoryData() {
        val repositoryId = arguments?.getInt(REPOSITORY_ID_KEY)
        viewModel.dispatch(DetailEvent.LoadInfoForRepositoryWithId(repositoryId))
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

    private fun showOverviewState(uiModel: DetailUiModel) = with(binding) {
        stateLoading.root.visibility = View.GONE
        stateError.root.visibility = View.GONE
        stateOverview.visibility = View.VISIBLE

        Picasso.get().load(uiModel.avatarUrl).into(icAvatar)
        name.text = getFormattedString(R.string.detail_name, uiModel.name)
        fullName.text = getFormattedString(R.string.detail_full_name, uiModel.fullName)

        uiModel.description?.let {
            description.text = getFormattedString(R.string.detail_description, it)
        }

        visibility.text = getFormattedString(R.string.detail_visibility, uiModel.visibility)
        isPrivate.text = getFormattedString(R.string.detail_is_private, uiModel.isPrivate.toString())

        ctaExternalBrowser.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(uiModel.htmlUrl)
            startActivity(intent)
        }
    }

    private fun getFormattedString(
        @StringRes resId: Int,
        value: String
    ) =
        resources.getString(resId, value)

}