package io.atto.android.usecase.reactive.subscribers

import io.reactivex.internal.subscribers.BlockingBaseSubscriber

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/29/2019
 * Time : 10:28 PM
 */

abstract class AttoFlowableSubscriber<R> : BlockingBaseSubscriber<R>()
