package com.example.temrecyclertools.ui.adapter

import android.view.View
import com.example.temrecyclertools.ui.viewHolder.LoadingViewHolder
import com.example.temrecyclertools.ui.viewHolder.LoadingRecyclerEntity
import com.example.temrecyclertools.ui.viewHolder.RECYCLERVIEW_LOADING_LAYOUT_ID

val loadingViewAdapter = BaseRecyclerViewAdapter(object : ViewHolderFactory {
    override fun getType(baseRecyclerEntity: BaseRecyclerEntity): Int = when (baseRecyclerEntity) {
        is LoadingRecyclerEntity -> RECYCLERVIEW_LOADING_LAYOUT_ID
        else -> throw IllegalArgumentException()
    }

    override fun getHolder(viewType: Int, view: View): BaseRecyclerViewHolder<*> = when (viewType) {
        RECYCLERVIEW_LOADING_LAYOUT_ID -> LoadingViewHolder(view)
        else -> throw IllegalArgumentException()
    }
})