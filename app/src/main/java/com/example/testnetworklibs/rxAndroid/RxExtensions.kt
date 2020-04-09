package com.example.testnetworklibs.rxAndroid

import com.example.testnetworklibs.states.ResultState
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.uniflow.androidx.flow.AndroidDataFlow
import io.uniflow.core.flow.data.UIState

fun <T> Observable<T>.toDataFlow(onNextState: Class<out ResultState<T>>, flow: AndroidDataFlow) {
    this.subscribe(
        object : Observer<T> {
            override fun onComplete() {
                flow.action { setState { UIState.Success } }
            }

            override fun onSubscribe(d: Disposable) {
                flow.action { setState(UIState.Loading) }
            }

            override fun onError(e: Throwable) {
                flow.action { setState(UIState.Failed(e.message, e)) }
            }

            override fun onNext(t: T) {
                flow.action {
                    if (t is Collection<*> && t.size<= 0){
                        setState { UIState.Empty }
                        return@action
                    }
                    val ctor = onNextState.constructors.first()
                    val obj = ctor.newInstance(t) as ResultState<*>
                    setState(obj)
                }
            }
        }
    )
}