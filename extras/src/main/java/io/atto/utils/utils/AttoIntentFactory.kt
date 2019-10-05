package io.atto.utils.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity


/**
 * Copyright (C) 2019 AttoImageLoaders IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/29/2019
 * Time : 10:31 PM
 */

inline fun <reified T : Any> AppCompatActivity.startScreen(
    isFinishEnabled: Boolean,
    options: Bundle? = null,
    noinline init: Intent.() -> Unit = {}
) {
    val intent = newIntent<T>(this)
    intent.init()
    startActivity(intent, options)
    if (isFinishEnabled) {
        finish()
    }
}

inline fun <reified T : Any> FragmentActivity.startScreen(
    isFinishEnabled: Boolean,
    options: Bundle? = null,
    noinline init: Intent.() -> Unit = {}
) {
    val intent = newIntent<T>(this)
    intent.init()
    startActivity(intent, options)
    if (isFinishEnabled) {
        finish()
    }
}


inline fun <reified T : Any> Fragment.startScreen(
    isFinishEnabled: Boolean,
    options: Bundle? = null,
    noinline init: Intent.() -> Unit = {}
) {
    val intent = newIntent<T>(activity!!)
    intent.init()
    startActivity(intent, options)
    if (isFinishEnabled) {
        activity!!.finish()
    }
}

inline fun <reified T : Any> Fragment.startScreenForResult(
    reqCode: Int,
    noinline init: Intent.() -> Unit = {}
) {
    val intent = newIntent<T>(activity!!)
    intent.init()
    startActivityForResult(intent, reqCode)
}

/**
 *  <uses-permission android:name="android.permission.CALL_PHONE" />
 */
fun FragmentActivity.startPhoneCall(phoneNumber: String) {
    val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$phoneNumber"))
    startActivity(intent)
}

fun Fragment.startPhoneCall(phoneNumber: String) {
    val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$phoneNumber"))
    startActivity(intent)
}

fun FragmentActivity.startWebPage(url: String) {
    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
}

fun Fragment.startWebPage(url: String) {
    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
}

inline fun <reified T> AppCompatActivity.getExtra(extra: String): T? {
    return intent.extras?.get(extra) as? T?
}

fun startApplicationByPackageName(packageName: String, context: Context) {
    val launchIntent = context.packageManager.getLaunchIntentForPackage(packageName)
    context.startActivity(launchIntent)
}

inline fun <reified T : Any> newIntent(context: Context): Intent = Intent(context, T::class.java)
