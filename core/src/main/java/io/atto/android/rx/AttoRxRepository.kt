package io.atto.android.rx

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 5:53 PM
 */

class AttoRxRepository {

    private val repo: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    fun addRequest(request: Disposable) {
        repo.add(request)
    }

    fun destroyReository() {
        repo.clear()
    }
}