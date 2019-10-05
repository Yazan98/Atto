package io.atto.utils.listeners

/**
 * Copyright (C) 2019 AttoImageLoaders IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 11:17 PM
 */

interface AttoFirebaseImageListener {

    fun onSuccess()

    fun onProgress(progress: Double)

    fun onError(ex: Exception)

}
