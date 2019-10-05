package io.atto.permissions

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 11:47 PM
 */

class AttoPermission {

    private var reqCode: Int = -1
    private var handler: AttoPermissionHandler? = null
    private var loggingStatus: AttoLoggingType? = null

    /**
     * use this method if you wanna log everything about your permission or not
     */
    fun registerLoggingStatus(status: AttoLoggingType): AttoPermission {
        this.loggingStatus = status
        return this
    }

    /**
     * use this method at first whem you wanna register your result handler to handle permission status
     */
    fun registerPermissionHandler(handler: AttoPermissionHandler?): AttoPermission {
        this.handler = handler
        return this
    }

    /**
     * this method check the permission if generated before or not
     */
    @Throws(AttoHandlerException::class)
    suspend fun checkPermissionStatus(context: Context, permission: String): AttoPermission {
        withContext(Dispatchers.Main) {
            when (handler) {
                null -> throw AttoHandlerException()
            }

            when (loggingStatus) {
                AttoLoggingType.ENABLED -> {
                    println(
                        """
                        ===========================================================================================
                        Atto Permissions Started...
                        Permission : $permission
                        Operation Name : Check Permission Status
                        Execution Therad : Main Thread...
                        ===========================================================================================
                    """.trimIndent()
                    )
                }
            }
            if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                when (loggingStatus) {
                    AttoLoggingType.ENABLED -> {
                        println(
                            """
                    ===========================================================================================
                    Atto Permission : $permission Status : Failed
                    ===========================================================================================
                """.trimIndent()
                        )
                        handler!!.onPermissionDenide(permission)
                    }
                }
            } else {
                when (loggingStatus) {
                    AttoLoggingType.ENABLED -> {
                        println(
                            """
                    ===========================================================================================
                    Atto Permission : $permission Status : Success
                    ===========================================================================================
                """.trimIndent()
                        )
                    }
                }
                handler!!.onPermissionSuccess(permission)
            }
        }
        return this
    }

    suspend fun requestOnePermission(context: Activity, permission: String, reqCode: Int): AttoPermission {
        this.reqCode = reqCode
        withContext(Dispatchers.Main) {
            ActivityCompat.requestPermissions(context, arrayOf(permission), reqCode)
        }
        return this
    }

    suspend fun requestMultiPermissions(context: Activity, reqCode: Int, vararg permissions: String): AttoPermission {
        this.reqCode = reqCode
        withContext(Dispatchers.Main) {
            for(permission in permissions) {
                if (!hasPermissions(context, permission)) {
                    ActivityCompat.requestPermissions(context, permissions, reqCode)
                }
            }
        }
        return this
    }

    private fun hasPermissions(context: Context?, vararg permissions: String): Boolean {
        if (context != null) {
            for (permission in permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false
                }
            }
        }
        return true
    }

    fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            this.reqCode -> {
                if (grantResults.isNotEmpty()
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED
                ) {
                    handler!!.onPermissionSuccess(permissions.toString())
                } else {
                    handler!!.onPermissionDenide(permissions.toString())
                }
            }
        }
    }

    /**
     * you should call this method at onDestroy Method or onStop to avoid memory leak
     */
    fun destroyPermissions() {
        this.handler = null
        this.reqCode = 0
        this.loggingStatus = null
    }

}