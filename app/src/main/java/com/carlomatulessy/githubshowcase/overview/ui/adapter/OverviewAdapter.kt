package com.carlomatulessy.githubshowcase.overview.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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
            Picasso.get().load(uiModel.avatarImage).into(avatar)

            // TODO improve with strings
            name.text = uiModel.name
            visibility.text = uiModel.visibility
            isPrivate.text = uiModel.private.toString()

            root.setOnClickListener { onItemCLicked(uiModel.id) }
        }
    }
}

