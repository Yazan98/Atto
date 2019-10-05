package io.atto.utils.logger

import com.crashlytics.android.Crashlytics
import io.atto.android.errors.OperationBlockedException
import io.atto.utils.custom.TimberReleaseTree
import timber.log.Timber

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 9/6/2019
 * Time : 12:12 AM
 */

object AttoLogger {

    /**
     * this boolean for the Project Status if at the Debug Mode Or At Release Mode
     * if at debug mode the messages will print at the logcat
     * if at release mode the messages will go to fabric
     */
    private var status: Boolean = false

    /**
     * you should provide the logging option at application class and this depends on your application status
     */
    private lateinit var initOption: LoggerOption

    /**
     * here you can initialize the logging for the application
     */
    fun initLogger(status: Boolean, initOption: LoggerOption, details: Any) {
        this.status = status
        this.initOption = initOption
        init(details)
    }

    /**
     * this method will config the logger depends on your option
     */
    @Throws(OperationBlockedException::class)
    private fun init(details: Any) {
        when (initOption) {
            LoggerOption.TIMBER -> {
                if (status) {
                    Timber.plant(Timber.DebugTree())
                } else {
                    Timber.plant(TimberReleaseTree())
                }
            }

            LoggerOption.CRASHLYTICS -> {
                if (details is CrashlyticsDetails) {
                    Crashlytics.setUserEmail(details.email)
                    Crashlytics.setUserIdentifier(details.userId.toString())
                    Crashlytics.setUserName(details.username)
                } else {
                    throw OperationBlockedException(
                        "The Logger Details Must Be Type Of CrashlyticsDetails To Provide The User Information"
                    )
                }
            }
        }
    }

    fun log(message: String) {
        showMessageByOption(message)
    }

    fun log(tag: String, message: String) {
        showMessageByOption("TAG : $tag , MESSAGE : $message")
    }

    fun logError(ex: Exception) {
        logException(ex)
    }

    fun logError(error: Throwable) {
        logException(error)
    }

    private fun showMessageByOption(message: String) {
        when (initOption) {
            LoggerOption.CRASHLYTICS -> {
                Crashlytics.log(message)
            }

            LoggerOption.TIMBER -> {
                Timber.d(message)
            }

            LoggerOption.ATTO -> {
                println(
                    """
                    ====================================================================================================
                    Atto Logging Starter ...
                    Atto Logger Content : $message
                    ====================================================================================================
                """.trimIndent()
                )
            }
        }
    }

    fun logException(ex: Throwable) {
        when (initOption) {
            LoggerOption.CRASHLYTICS -> {
                Crashlytics.logException(ex)
            }

            LoggerOption.TIMBER -> {
                Timber.e(ex)
            }

            LoggerOption.ATTO -> {
                println(
                    """
                    ====================================================================================================
                    Atto Logging Starter ...
                    Atto Logging Type : Exception Logger
                    Atto Exception Type : ${ex::class.java.name}
                    Atto Exception Message : ${ex.message}
                    Atto Exception Stacktrace : ${ex.printStackTrace()}
                    ====================================================================================================
                """.trimIndent()
                )
            }
        }
    }


}
