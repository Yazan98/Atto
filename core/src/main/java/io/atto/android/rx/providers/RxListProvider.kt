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
 * Time : 10:10 PM
 */

abstract class RxListProvider<T> : RxProvider<List<T>> {

    override fun getObservable(request: Observable<List<T>>): Observable<List<T>> {
        return request
            .subscribeOn(getThreadProvider().getIoThread())
            .observeOn(getThreadProvider().getMainThread())
    }

    override fun getFlowable(request: Flowable<List<T>>): Flowable<List<T>> {
        return request
            .subscribeOn(getThreadProvider().getIoThread())
            .observeOn(getThreadProvider().getMainThread())
    }

    override fun getSingle(request: Single<List<T>>): Single<List<T>> {
        return request
            .subscribeOn(getThreadProvider().getIoThread())
            .observeOn(getThreadProvider().getMainThread())
    }

}
