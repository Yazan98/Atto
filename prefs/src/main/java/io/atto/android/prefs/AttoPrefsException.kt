package io.atto.android.prefs


/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 11:51 PM
 */

class AttoPrefsException : Exception(
    """
        You Should initialize Atto Prefs At Application Class Before Use This Method
        Apply This At Application Class :

        override fun onCreate() {
            super.onCreate()
            AttoPrefsConfig.init(applicationContext, "Atto")
        }

    """.trimIndent()
) 