package com.carlomatulessy.githubshowcase.overview.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.carlomatulessy.githubshowcase.overview.ui.viewmodel.OverviewViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by viewModel()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}