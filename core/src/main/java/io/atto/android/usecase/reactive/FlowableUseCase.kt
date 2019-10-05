package io.atto.android.usecase.reactive

import io.atto.android.usecase.AttoUseCase
import io.reactivex.Flowable

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/29/2019
 * Time : 10:25 PM
 */

abstract class FlowableUseCase<Request , Params> : AttoUseCase.ReactiveUseCase<Flowable<Request> , Params>()
