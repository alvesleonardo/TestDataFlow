package com.example.temrecyclertools.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface BaseRecyclerEntity

interface ViewHolderFactory {
    fun getType(recyclerEntity: BaseRecyclerEntity): Int
    fun getHolder(viewType: Int, view: View): BaseRecyclerViewHolder<*>
}

abstract class BaseRecyclerViewHolder<in T : BaseRecyclerEntity>(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    interface Listener<T> {
        fun onClick(recyclerEntity: T)
    }

    abstract fun bind(recyclerEntity: T)
    abstract fun recycle()
}

class BaseRecyclerViewAdapter(private val viewHolderFactory: ViewHolderFactory) :
    RecyclerView.Adapter<BaseRecyclerViewHolder<BaseRecyclerEntity>>() {

    private var recyclerView: RecyclerView? = null

    private val items = arrayListOf<BaseRecyclerEntity>()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        this.recyclerView = recyclerView
    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerViewHolder<BaseRecyclerEntity> {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return viewHolderFactory.getHolder(
            viewType,
            view
        ) as BaseRecyclerViewHolder<BaseRecyclerEntity>
    }

    override fun onBindViewHolder(
        holderBaseRecycler: BaseRecyclerViewHolder<BaseRecyclerEntity>,
        position: Int
    ) {
        holderBaseRecycler.bind(items[position])
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = viewHolderFactory.getType(items[position])

    fun setItem(item: BaseRecyclerEntity) {
        with(this@BaseRecyclerViewAdapter.items) {
            clear()
            add(item)
        }
        notifyDataSetChanged()
    }

    fun setItems(items: List<BaseRecyclerEntity>) {
        with(this@BaseRecyclerViewAdapter.items) {
            clear()
            addAll(items)
        }
        notifyDataSetChanged()
    }

    fun addItems(items: List<BaseRecyclerEntity>) {
        val firstInsertionPosition = this@BaseRecyclerViewAdapter.items.size + 1
        this@BaseRecyclerViewAdapter.items.addAll(items)
        notifyItemRangeInserted(firstInsertionPosition, this@BaseRecyclerViewAdapter.items.size)
    }

    fun addItem(item: BaseRecyclerEntity) {
        val firstInsertionPosition = this@BaseRecyclerViewAdapter.items.size + 1
        this@BaseRecyclerViewAdapter.items.add(item)
        notifyItemRangeInserted(firstInsertionPosition, this@BaseRecyclerViewAdapter.items.size)
    }

    override fun onViewRecycled(holderBaseRecycler: BaseRecyclerViewHolder<BaseRecyclerEntity>) {
        holderBaseRecycler.recycle()
    }

    fun getItemByPosition(position: Int) = items[position]

    fun getItem(baseRecyclerEntity: BaseRecyclerEntity): BaseRecyclerEntity? {
        val index = items.indexOf(baseRecyclerEntity)
        if (index < 0) return null
        return items[index]
    }

    fun <R : BaseRecyclerEntity> getItemFromType(kClass: Class<R>): List<R> {
        return items.filterIsInstance(kClass)
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }

}