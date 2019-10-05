package io.atto.android.prefs

import android.content.Context
import android.content.SharedPreferences

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 11:51 PM
 */

object AttoPrefsConfig {

    lateinit var prefs: SharedPreferences

    fun init(context: Context, packageName: String) {
        prefs = context.getSharedPreferences(packageName, Context.MODE_PRIVATE)
    }

    fun checkStatus(): Boolean {
        return AttoPrefsConfig::prefs.isInitialized
    }

}