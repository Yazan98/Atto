package io.atto.ui.screen

import android.content.Context
import android.net.ConnectivityManager
import io.atto.android.rx.AttoRxRepository
import io.atto.android.state.NetworkState
import io.atto.android.view.AttoView
import io.atto.logic.AttoRxViewModel
import io.reactivex.Observable

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/31/2019
 * Time : 10:56 AM
 */

abstract class AttoStreamingScreen<View : AttoView, State, ViewModel : AttoRxViewModel<View, State>> :
    AttoRxScreen<View, State, ViewModel>() {

    private val repository: AttoRxRepository by lazy {
        AttoRxRepository()
    }

    override fun onStart() {
        super.onStart()
        repository.addRequest(
            internetListener(this).subscribe {
                if (it) {
                    onNetworkState(NetworkState.CONNECTED)
                } else {
                    onNetworkState(NetworkState.DISCONNECTED)
                }
            }
        )
    }

    private fun internetListener(context: Context): Observable<Boolean> {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return Observable.just(activeNetworkInfo != null && activeNetworkInfo.isConnected)
    }

    override fun onDestroy() {
        super.onDestroy()
        repository.destroyReository()
        getViewModel().destroyViewModel()
    }

    override fun onStop() {
        super.onStop()
        getViewModel().destroyViewModel()
    }

    protected abstract fun onNetworkState(newState: NetworkState)
}
