package io.atto.android

import io.atto.android.errors.PlatformMissingException

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/29/2019
 * Time : 9:11 PM
 */

abstract class PlatformValidator {

    private fun check(name: String, errorMessage: String) {
        try {
            Class.forName(name)
        } catch (e: ClassNotFoundException) {
            throw PlatformMissingException(errorMessage)
        }
    }

    fun execute() {
        for (i in getPlatforms().indices) {
            check(getPlatforms()[i].name, getPlatforms()[i].errorMessage)
        }
    }

    protected abstract fun getPlatforms(): ArrayList<Platform>

}
