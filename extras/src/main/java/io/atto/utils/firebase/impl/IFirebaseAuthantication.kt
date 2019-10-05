package io.atto.utils.firebase.impl

import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import io.atto.utils.listeners.FirebaseAuthListener

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 11:33 PM
 */

interface IFirebaseAuthantication {

    fun signInWithEmailAndPassword(email: String, password: String)

    fun createAccountWithEmailAndPassword(email: String, password: String)

    fun loadListener(listener: FirebaseAuthListener)

    fun getAuthListener(): OnCompleteListener<AuthResult>

    fun signInWithAuthConfig(context: AppCompatActivity, requestCode: Int, methods: ArrayList<AuthUI.IdpConfig>)

    fun destroyFirebaseListener()

}
