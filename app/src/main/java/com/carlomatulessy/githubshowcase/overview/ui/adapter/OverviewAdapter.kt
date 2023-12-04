package com.carlomatulessy.githubshowcase.overview.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView
import com.carlomatulessy.githubshowcase.R
import com.carlomatulessy.githubshowcase.databinding.ListItemOverviewBinding
import com.carlomatulessy.githubshowcase.overview.ui.model.GithubRepositoryInfoUiModel
import com.squareup.picasso.Picasso

class OverviewAdapter(
    private val uiModels: List<GithubRepositoryInfoUiModel>,
    private val onItemCLicked: ((Int) -> Unit)
) : RecyclerView.Adapter<OverviewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ListItemOverviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(uiModels[position])
    }

    override fun getItemCount(): Int =
        uiModels.size

    inner class ViewHolder(
        private val binding: ListItemOverviewBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(uiModel: GithubRepositoryInfoUiModel) = with(binding) {
            Picasso.get().load(uiModel.avatarUrl).into(avatar)

            // TODO improve with strings
            name.text = uiModel.name
            visibility.text = getFormattedString(R.string.overview_visibility, uiModel.visibility)
            isPrivate.text = getFormattedString(R.string.overview_is_private, uiModel.isPrivate.toString())

            root.setOnClickListener { onItemCLicked(uiModel.id) }
        }

        private fun getFormattedString(
            @StringRes resId: Int,
            value: String
        ) =
            binding.root.resources.getString(resId, value)
    }
}

