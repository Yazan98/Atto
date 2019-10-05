package io.atto.utils.listeners

import com.google.firebase.auth.FirebaseUser

/**
 * Copyright (C) 2019 AttoImageLoaders IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 11:16 PM
 */

interface FirebaseAuthListener {

    fun onAuthCompleted(user: FirebaseUser)

    fun onAuthFailed(message: String)

}