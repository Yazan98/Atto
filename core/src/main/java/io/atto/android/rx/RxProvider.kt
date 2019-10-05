package io.atto.android.rx

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/29/2019
 * Time : 10:08 PM
 */

interface RxProvider<T> {

    fun getObservable(request: Observable<T>): Observable<T>

    fun getFlowable(request: Flowable<T>): Flowable<T>

    fun getSingle(request: Single<T>): Single<T>

    fun getThreadProvider(): AttoThreadProvider

}
