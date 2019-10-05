package io.atto.android.rx.providers

import io.atto.android.rx.RxProvider
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/29/2019
 * Time : 10:09 PM
 */

abstract class RxSingleProvider<T> : RxProvider<T> {

    override fun getObservable(request: Observable<T>): Observable<T> {
        return request
            .subscribeOn(getThreadProvider().getIoThread())
            .observeOn(getThreadProvider().getMainThread())
    }

    override fun getFlowable(request: Flowable<T>): Flowable<T> {
        return request
            .subscribeOn(getThreadProvider().getIoThread())
            .observeOn(getThreadProvider().getMainThread())
    }

    override fun getSingle(request: Single<T>): Single<T> {
        return request
            .subscribeOn(getThreadProvider().getIoThread())
            .observeOn(getThreadProvider().getMainThread())
    }

}
