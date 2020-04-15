package com.example.testnetworklibs.ui

import com.example.temrecyclertools.ui.adapter.BaseRecyclerEntity

class RepositoryViewModel(val name: String) : BaseRecyclerEntity{
    override fun getItemId() = name

    override fun equals(other: Any?): Boolean {
        return if (other is RepositoryViewModel){
            other.name == this.name
        }else {
            false
        }
    }
}