package io.atto.utils.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * Copyright (C) 2019 AttoImageLoaders IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 11:08 PM
 */

object NetworkUtils {

    private var connectivityManager: ConnectivityManager? = null
    private var nwInfo: NetworkInfo? = null
    private var cm: ConnectivityManager? = null

    @SuppressLint("MissingPermission")
    fun isNetworkConnection(context: Context): Boolean {
        connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        val nwInfo = connectivityManager!!.activeNetworkInfo
        return nwInfo != null && nwInfo.isConnectedOrConnecting
    }

    private fun getNetworkInfo(context: Context): NetworkInfo {
        cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return cm!!.activeNetworkInfo
    }

}