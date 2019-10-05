package io.atto.utils.sms

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.OnLifecycleEvent
import io.atto.utils.listeners.AttoSmsListener

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 9/6/2019
 * Time : 1:16 AM
 */

// myLifecycleOwner.getLifecycle().addObserver(MyObserver())
class AttoMessageHandler(private val context: FragmentActivity , listener: AttoSmsListener?) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun registerReceiver() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun unregisterReceiver() {

    }

}
