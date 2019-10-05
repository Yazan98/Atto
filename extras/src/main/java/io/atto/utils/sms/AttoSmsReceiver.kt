package io.atto.utils.sms

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import io.atto.utils.listeners.AttoSmsListener


/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 9/6/2019
 * Time : 1:03 AM
 */

/**
 * <receiver
    android:name=
    "io.atto.utils.sms.AttoSmsReceiver"
    android:enabled="true"
    android:exported="true">
        <intent-filter>
            <action android:name="android.provider.Telephony.SMS_RECEIVED"/>
        </intent-filter>
    </receiver>
 */
class AttoSmsReceiver : BroadcastReceiver() {

    private var listener: AttoSmsListener? = null

    override fun onReceive(p0: Context?, p1: Intent?) {
        println("Atto Sms Receiver Action : ${p1!!.action}")
        if (p1.action.equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)) {
            val smsMessages = Telephony.Sms.Intents.getMessagesFromIntent(p1)
            if(listener != null) {
                listener!!.onMessageReceive(smsMessages)
            }
        }
    }

    fun addListener(listener: AttoSmsListener) {
        this.listener = listener
    }

    fun destroyReceiver() {
        this.listener = null
    }

}
