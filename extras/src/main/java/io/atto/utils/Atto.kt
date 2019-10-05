package io.atto.utils

import android.app.Application
import android.os.Handler
import android.os.StrictMode
import android.os.StrictMode.setThreadPolicy
import android.os.StrictMode.setVmPolicy
import androidx.appcompat.app.AppCompatDelegate
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.answers.Answers
import com.crashlytics.android.core.CrashlyticsCore
import com.facebook.drawee.backends.pipeline.Fresco
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import io.atto.utils.custom.AttoCheckState
import io.atto.utils.custom.TimberReleaseTree
import io.fabric.sdk.android.Fabric
import leakcanary.LeakSentry
import timber.log.Timber

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 11:43 PM
 */

object Atto : IAtto {

    private var state: Boolean = false
    lateinit var app: Application

    override fun addApplicationStatus(appStatus: Boolean): Atto {
        this.state = appStatus
        return this
    }

    override fun startStrictMode(): Atto {
        if (state) {
            Handler().postAtFrontOfQueue {
                setThreadPolicy(
                    StrictMode.ThreadPolicy.Builder()
                        .detectAll()
                        .build()
                )
                setVmPolicy(
                    StrictMode.VmPolicy.Builder()
                        .detectLeakedSqlLiteObjects()
                        .penaltyLog()
                        .penaltyDeath()
                        .build()
                )
            }
        }
        return this
    }

    override fun startFirebase(application: Application): Atto {
        FirebaseApp.initializeApp(application)
        FirebaseAnalytics.getInstance(application)
        return this
    }

    override fun startLeakCanary(application: Application): Atto {
        if (state) {
            LeakSentry.config = LeakSentry.config.copy(watchFragmentViews = true)
        }
        return this
    }

    override fun startImageLoader(loader: ImageLoader, application: Application): Atto {
        when (loader) {
            ImageLoader.FRESCO -> Fresco.initialize(application)
            ImageLoader.PICASSO -> {
                Picasso.setSingletonInstance(
                    Picasso.Builder(application)
                        .downloader(OkHttp3Downloader(application))
                        .build()
                )
            }
        }
        return this
    }

    override fun startTimber(application: Application): Atto {
        if (state) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(TimberReleaseTree())
        }
        return this
    }

    override fun registerExceptionHandler(handler: Thread.UncaughtExceptionHandler): Atto {
        Thread.currentThread().uncaughtExceptionHandler = handler
        return this
    }

    override fun registerCompatVector(): Atto {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        return this
    }

    override fun startCrashlytice(application: Application): Atto {
        Fabric.with(
            application, Crashlytics.Builder()
                .core(
                    CrashlyticsCore.Builder()
                        .disabled(state)
                        .build()
                )
                .answers(Answers())
                .build()
        )
        return this
    }

    override fun addApplication(app: Application): Atto {
        this.app = app
        return this
    }

    override fun build(): Atto {
        AttoCheckState().execute()
        return this
    }

}
