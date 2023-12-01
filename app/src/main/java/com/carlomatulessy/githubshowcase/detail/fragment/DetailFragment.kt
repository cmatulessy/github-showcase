package com.carlomatulessy.githubshowcase.detail.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.carlomatulessy.githubshowcase.databinding.FragmentDetailBinding
import com.carlomatulessy.githubshowcase.overview.ui.fragment.OverviewFragment.Companion.REPOSITORY_ID_KEY

class DetailFragment : Fragment() {
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
        val repositoryId = arguments?.getInt(REPOSITORY_ID_KEY)

//        observeUi()
    }
}