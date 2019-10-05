package io.atto.data.executors

import io.atto.android.AttoConsts
import io.atto.android.AttoHandler
import io.atto.android.errors.OperationBlockedException
import io.atto.data.AttoObservableRequestExecutor
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import java.lang.ref.WeakReference

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 5:56 PM
 */

class AttoObservableExecutor<T> : AttoObservableRequestExecutor<T> {

    var mainHandler: WeakReference<AttoHandler>? = null

    override fun addHandler(handler: AttoHandler) {
        mainHandler = WeakReference(handler)
    }

    override fun subscribeRequest(request: Observable<T>): Disposable {
        return request.subscribe(
            { response ->
                preProccessExecutor()
                mainHandler?.get().let {
                    it?.onSuccess(response!!)
                }
            }, { error ->
                preProccessExecutor()
                mainHandler?.get().let {
                    it?.onError(error)
                }
            }
        )
    }

    override fun preProccessExecutor() {
        if (mainHandler == null) {
            throw OperationBlockedException(AttoConsts.EXECUTOR_HANDLER_EMPTY)
        }
    }

    override fun destroyExecutor() {
        if (mainHandler != null) {
            mainHandler?.clear()
            mainHandler = null
        }
    }

}
