package io.atto.ui.screen

import androidx.lifecycle.Observer
import io.atto.android.view.AttoStateView
import io.atto.android.view.AttoView
import io.atto.logic.AttoRxViewModel
import io.atto.ui.base.AttoScreen

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 7:05 PM
 */

abstract class AttoRxScreen<View : AttoView , State , ViewModel : AttoRxViewModel<View , State>> : AttoScreen() ,
    AttoStateView<State> {

    private val stateObserver = Observer<State> {
        onNewState(it)
    }

    private fun startHandler() {
        getViewModel().getState().observe(this , stateObserver)
    }

    override fun onResume() {
        super.onResume()
        startHandler()
        initScreen()
    }

    override fun onStop() {
        super.onStop()
        getViewModel().getState().removeObserver(stateObserver)
        getViewModel().destroyViewModel()
    }

    override fun onDestroy() {
        super.onDestroy()
        getViewModel().getState().removeObserver(stateObserver)
        getViewModel().destroyViewModel()
        getViewModel().detachView()
    }

    protected abstract fun getViewModel(): ViewModel
    protected abstract fun initScreen()
}
