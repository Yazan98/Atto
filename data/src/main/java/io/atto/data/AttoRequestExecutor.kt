package io.atto.data

import io.atto.android.AttoHandler
import io.atto.android.usecase.reactive.subscribers.AttoFlowableSubscriber
import io.atto.android.usecase.reactive.subscribers.AttoObservableSubscriber
import io.atto.android.usecase.reactive.subscribers.AttoSingleSubscriber
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable

/**s
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 5:52 PM
 */

interface AttoRequestExecutor<T, Type, Subscriber> {

    fun addHandler(handler: AttoHandler)

    fun subscribeRequest(request: Type): Disposable

//    fun getSubscriber(): Subscriber

    fun destroyExecutor()

    fun preProccessExecutor()

}

interface AttoObservableRequestExecutor<T> : AttoRequestExecutor<T, Observable<T>, AttoObservableSubscriber<T>>
interface AttoSingleRequestExecutor<T> : AttoRequestExecutor<T, Single<T>, AttoSingleSubscriber<T>>
interface AttoFlowableRequestExecutor<T> : AttoRequestExecutor<T, Flowable<T>, AttoFlowableSubscriber<T>>
