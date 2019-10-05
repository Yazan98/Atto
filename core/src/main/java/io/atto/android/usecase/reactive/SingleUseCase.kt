package io.atto.android.usecase.reactive

import io.atto.android.usecase.AttoUseCase
import io.reactivex.Single

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/29/2019
 * Time : 10:26 PM
 */

abstract class SingleUseCase<Request , Params> : AttoUseCase.ReactiveUseCase<Single<Request> , Params>()
