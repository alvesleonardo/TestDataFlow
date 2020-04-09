package com.example.testnetworklibs.ui.viewHolder

import android.view.View
import android.widget.TextView
import com.example.temrecyclertools.ui.adapter.BaseRecyclerViewHolder
import com.example.testnetworklibs.R
import com.example.testnetworklibs.ui.RepositoryViewModel

val REPOSITORY_LAYOUT_ID = R.layout.item_view_repository

class RepositoryViewHolder(itemView: View) : BaseRecyclerViewHolder<RepositoryViewModel>(itemView) {
    override fun bind(viewModel: RepositoryViewModel) {
        itemView.findViewById<TextView>(R.id.tvName).text = viewModel.name
    }

    override fun recycle() {}
}