package com.example.testnetworklibs.states

import androidx.paging.PagedList
import com.example.testnetworklibs.ui.RepositoryViewModel

class RepositoryState(repos: PagedList<RepositoryViewModel>) : ResultState<PagedList<RepositoryViewModel>>(repos)
