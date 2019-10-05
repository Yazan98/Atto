package io.atto.utils.utils

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessaging

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/31/2019
 * Time : 11:25 AM
 */

object AttoNotificationUtils {

    fun showNotification(
        channelId: String,
        context: Context,
        iconId: Int,
        title: String,
        body: String,
        notificationId: Int
    ) {
        val builder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(iconId)
            .setContentTitle(title)
            .setContentText(body)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(context)) {
            notify(notificationId, builder.build())
        }
    }

    fun showNotificationWithIntent(
        channelId: String,
        context: Context,
        iconId: Int,
        title: String,
        body: String,
        notificationId: Int,
        targetClass: Class<*>
    ) {
        val intent = Intent(context, targetClass).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

        val builder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(iconId)
            .setContentTitle(title)
            .setContentText(body)
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(context)) {
            notify(notificationId, builder.build())
        }
    }

    fun subscribeTopic(name: String) {
        FirebaseMessaging.getInstance().subscribeToTopic(name)
    }

    fun unSubscribeTopic(name: String) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic(name)
    }

}
