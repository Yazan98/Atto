package io.atto.android.errors

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/29/2019
 * Time : 9:47 PM
 */

class BadRequestException(override val message: String) : AttoException(message) {
    init {
        println("""
            =========================================================================================================
            Atto Exception Started ...
            Exception Type : BadRequestException
            Error Message : $message
            Exception Stacktrace : ${printStackTrace()}
            =========================================================================================================
        """.trimIndent())
    }
}
