package io.atto.android.usecase.reactive

import io.atto.android.usecase.AttoUseCase
import io.reactivex.Observable

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/29/2019
 * Time : 10:24 PM
 */

abstract class ObservableUseCase<Request , Params> : AttoUseCase.ReactiveUseCase<Observable<Request> , Params>()

