package com.example.testnetworklibs.states

import io.uniflow.core.flow.data.UIState


open class ResultState<T>(var value: T) : UIState(){}