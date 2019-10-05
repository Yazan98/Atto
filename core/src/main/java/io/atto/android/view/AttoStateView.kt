package io.atto.android.view

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/29/2019
 * Time : 10:18 PM
 */

interface AttoStateView<State> : AttoView {

    fun onNewState(newState: State)

}
