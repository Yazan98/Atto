package io.atto.utils.utils

import android.content.Context
import android.widget.Toast
import android.widget.TextView
import android.R



/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/31/2019
 * Time : 11:18 AM
 */

object AttoToastUtils {

    fun showToastByType(context: Context , message: Int , type: ToastType) {
        when (type) {
            ToastType.DEFAULT -> showDefault(context , message)
            ToastType.SUCCESS -> showSuccessToast(context , message)
            ToastType.ERROR -> showErrorToast(context , message)
        }
    }

    private fun showDefault(context: Context, message: Int) {
        Toast.makeText(context , context.resources.getString(message) , Toast.LENGTH_SHORT).show()
    }

    private fun showSuccessToast(context: Context, message: Int) {
        val toast = Toast.makeText(context, context.getString(message), Toast.LENGTH_LONG)
        val view = toast.view
        view.setBackgroundResource(R.color.holo_green_light)
        toast.show()
    }

    private fun showErrorToast(context: Context, message: Int) {
        val toast = Toast.makeText(context, context.getString(message), Toast.LENGTH_LONG)
        val view = toast.view
        view.setBackgroundResource(R.color.holo_red_light)
        toast.show()
    }

}

enum class ToastType {
    SUCCESS , ERROR , DEFAULT
}
