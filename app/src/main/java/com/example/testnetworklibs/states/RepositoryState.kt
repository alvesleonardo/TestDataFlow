package com.example.testnetworklibs.states

import com.example.testnetworklibs.entities.Repository
import io.uniflow.core.flow.data.UIState

class RepositoryState(repos: List<Repository>) : ResultState<List<Repository>>(repos)
