package io.atto.logic

import androidx.lifecycle.MutableLiveData
import io.atto.android.AttoSubscriber
import io.atto.android.view.AttoView
import io.reactivex.disposables.Disposable

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 6:30 PM
 */

interface AttoViewModelImpl<View : AttoView, State> {

    fun setView(view: View)

    fun getView(): View

    fun detachView()

    fun getState(): MutableLiveData<State>

    fun addRxRepository(request: Disposable)

    fun acceptNewState(newState: State)

    fun destroyViewModel()

    fun executeRequest(request: Any)

}