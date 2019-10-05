package io.atto.utils.custom

import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/31/2019
 * Time : 11:07 AM
 */

inline fun AppCompatActivity.showDialog(title: CharSequence = "", message: CharSequence = "" , func: AlertDialog.() -> Unit) {
    AlertDialog.Builder(this)
        .setMessage(message)
        .setTitle(title)
        .setCancelable(true)
        .show()
}

inline fun Fragment.showDialog(title: CharSequence = "", message: CharSequence = "" , func: AlertDialog.() -> Unit) {
    AlertDialog.Builder(activity!!)
        .setMessage(message)
        .setTitle(title)
        .setCancelable(true)
        .show()
}


