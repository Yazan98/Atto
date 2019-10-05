package io.atto.android.rx

import io.atto.android.rx.providers.RxSingleProvider

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/29/2019
 * Time : 10:14 PM
 */

class AttoRequestProvider<T> : RxSingleProvider<T>() {

    override fun getThreadProvider(): AttoThreadProvider {
        return object : AttoThreadProvider {}
    }

}