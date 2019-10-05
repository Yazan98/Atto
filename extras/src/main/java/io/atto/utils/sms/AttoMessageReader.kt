package io.atto.utils.sms

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 9/6/2019
 * Time : 12:54 AM
 */

object AttoMessageReader {

    suspend fun checkSmsPermission(context: Context): Boolean {
        return withContext(Dispatchers.IO) {
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.RECEIVE_SMS
            ) != PackageManager.PERMISSION_GRANTED
        }
    }

    /**
     *   <uses-permission android:name="android.permission.SEND_SMS" />
     *   <uses-permission android:name="android.permission.RECEIVE_SMS" />
     */
    suspend fun executePermission(context: FragmentActivity, reqCode: Int) {
        if (!ActivityCompat.shouldShowRequestPermissionRationale(context, Manifest.permission.RECEIVE_SMS)) {
            withContext(Dispatchers.Main) {
                ActivityCompat.requestPermissions(context, arrayOf(Manifest.permission.RECEIVE_SMS), reqCode)
            }
        }
    }

}
