package io.atto.utils

import android.app.Application

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 11:40 PM
 */

interface IAtto {

    fun addApplicationStatus(appStatus: Boolean): Atto

    fun startStrictMode(): Atto

    fun startFirebase(application: Application): Atto

    fun startLeakCanary(application: Application): Atto

    fun startImageLoader(loader: ImageLoader, application: Application): Atto

    fun startTimber(application: Application): Atto

    fun registerExceptionHandler(handler: Thread.UncaughtExceptionHandler): Atto

    fun registerCompatVector(): Atto

    fun startCrashlytice(application: Application):Atto

    fun addApplication(app: Application): Atto

    fun build(): Atto

}