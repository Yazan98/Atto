package io.atto.android.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/29/2019
 * Time : 10:06 PM
 */

interface AttoThreadProvider {

    fun getMainThread(): Scheduler = AndroidSchedulers.mainThread()

    fun getIoThread(): Scheduler = Schedulers.io()

}
