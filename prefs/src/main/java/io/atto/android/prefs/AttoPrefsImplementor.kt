package io.atto.android.prefs

import io.reactivex.Observable
import io.reactivex.observers.DisposableObserver

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 11:50 PM
 */

interface AttoPrefsImplementor {

    operator fun <T : Any> get(key: String, defValue: T, listener: DisposableObserver<T>?)

    fun <T : Any> getObservable(key: String, defValue: T): Observable<T>

    suspend fun put(key: String, value: Any)

    fun destroy()

}