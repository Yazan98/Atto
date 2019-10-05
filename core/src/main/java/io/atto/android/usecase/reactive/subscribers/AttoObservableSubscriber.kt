package io.atto.android.usecase.reactive.subscribers

import io.reactivex.observers.DisposableObserver

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/29/2019
 * Time : 10:26 PM
 */

abstract class AttoObservableSubscriber<R> : DisposableObserver<R>()
