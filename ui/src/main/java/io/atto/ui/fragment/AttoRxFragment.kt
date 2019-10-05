package io.atto.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import io.atto.android.view.AttoStateView
import io.atto.android.view.AttoView
import io.atto.logic.AttoRxViewModel
import io.atto.ui.base.AttoFragment

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 7:13 PM
 */

abstract class AttoRxFragment<View : AttoView, State , ViewModel : AttoRxViewModel<View, State>> : AttoFragment() ,
    AttoStateView<State> {

    private val stateObserver = Observer<State> {
        onNewState(it)
    }

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startHandler()
        initScreen()
    }

    override fun onResume() {
        super.onResume()
        startHandler()
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

    private fun startHandler() {
        getViewModel().getState().observe(this , stateObserver)
    }

    protected abstract fun getViewModel(): ViewModel
    protected abstract fun initScreen()
}