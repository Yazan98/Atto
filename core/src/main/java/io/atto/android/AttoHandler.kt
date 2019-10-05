package io.atto.android

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 6:01 PM
 */

interface AttoHandler {

    fun onSuccess(data: Any)

    fun onError(error: Throwable)

}
