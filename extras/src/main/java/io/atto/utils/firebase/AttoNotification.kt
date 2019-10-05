package io.atto.utils.firebase

import android.content.Context

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/31/2019
 * Time : 11:34 AM
 */

data class AttoNotification(
    val channelId: String,
    val context: Context,
    val iconId: Int,
    val title: String,
    val body: String,
    val notificationId: Int,
    val targetClass: Class<*>
)
