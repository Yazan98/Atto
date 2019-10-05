package io.atto.logic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.atto.android.AttoConsts
import io.atto.android.AttoHandler
import io.atto.android.errors.ViewNotAttachedException
import io.atto.android.rx.AttoRxRepository
import io.atto.android.view.AttoView
import io.reactivex.disposables.Disposable
import java.lang.ref.WeakReference

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 6:29 PM
 */

abstract class AttoRxViewModel<View : AttoView, State> : ViewModel(), AttoHandler, AttoViewModelImpl<View, State> {

    private var viewHandler: WeakReference<View>? = null
    private val repository: AttoRxRepository by lazy { AttoRxRepository() }
    private val stateObservable: MutableLiveData<State> by lazy { MutableLiveData<State>() }

    override fun setView(view: View) {
        viewHandler = WeakReference(view)
    }

    @Throws(ViewNotAttachedException::class)
    override fun getView(): View {
        return viewHandler?.get()!!
    }

    override fun getState(): MutableLiveData<State> {
        return stateObservable
    }

    override fun addRxRepository(request: Disposable) {
        repository.addRequest(request)
    }

    override fun acceptNewState(newState: State) {
        getState().postValue(newState)
    }

    override fun detachView() {
        if (viewHandler != null) {
            viewHandler?.clear()
            viewHandler = null
        }
    }

    override fun destroyViewModel() {
        this.repository.destroyReository()
    }

}
