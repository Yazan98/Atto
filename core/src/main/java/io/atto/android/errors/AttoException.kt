package io.atto.android.errors

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/29/2019
 * Time : 9:26 PM
 */

open class AttoException(override val message: String) : Exception(message)
