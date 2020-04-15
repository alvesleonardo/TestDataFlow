package com.example.temrecyclertools.ui.viewHolder

import android.view.View
import com.example.temrecyclertools.R.layout.view_loading
import com.example.temrecyclertools.ui.adapter.BaseRecyclerEntity
import com.example.temrecyclertools.ui.adapter.BaseRecyclerViewHolder

val RECYCLERVIEW_LOADING_LAYOUT_ID = view_loading

class LoadingViewHolder(itemView: View) : BaseRecyclerViewHolder<LoadingRecyclerEntity>(itemView) {
    override fun bind(recyclerEntity: LoadingRecyclerEntity) {}
    override fun recycle() {}
}

class LoadingRecyclerEntity: BaseRecyclerEntity {
    override fun getItemId() = 1
    override fun equals(other: Any?) = true
    override fun hashCode() = 1
}