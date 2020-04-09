package com.example.temrecyclertools.ui.viewHolder

import android.view.View
import com.example.temrecyclertools.R.layout.view_loading
import com.example.temrecyclertools.ui.adapter.BaseRecyclerEntity
import com.example.temrecyclertools.ui.adapter.BaseRecyclerViewHolder

val RECYCLERVIEW_LOADING_LAYOUT_ID = view_loading

class LoadingViewHolder(itemView: View) : BaseRecyclerViewHolder<LoadingViewModel>(itemView) {
    override fun bind(viewModel: LoadingViewModel) {}

    override fun recycle() {}
}

class LoadingViewModel: BaseRecyclerEntity