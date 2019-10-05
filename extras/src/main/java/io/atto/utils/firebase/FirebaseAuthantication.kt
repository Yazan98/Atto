package io.atto.utils.firebase

import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import io.atto.utils.firebase.impl.IFirebaseAuthantication
import io.atto.utils.listeners.FirebaseAuthListener

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 11:33 PM
 */

object FirebaseAuthantication : IFirebaseAuthantication {

    private var listener: FirebaseAuthListener? = null

    override fun signInWithEmailAndPassword(email: String, password: String) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(getAuthListener())
    }

    override fun createAccountWithEmailAndPassword(email: String, password: String) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(getAuthListener())
    }

    override fun loadListener(listener: FirebaseAuthListener) {
        this.listener = listener
    }

    override fun getAuthListener(): OnCompleteListener<AuthResult> {
        return OnCompleteListener {
            if (!it.isSuccessful) {
                listener?.onAuthFailed(it.exception!!.message!!)
            } else {
                listener?.onAuthCompleted(it.result!!.user!!)
            }
        }
    }

    /**
    new AuthUI.IdpConfig.GoogleBuilder().build(),
    new AuthUI.IdpConfig.FacebookBuilder().build(),
    new AuthUI.IdpConfig.TwitterBuilder().build(),
    new AuthUI.IdpConfig.GitHubBuilder().build(),
    new AuthUI.IdpConfig.EmailBuilder().build(),
    new AuthUI.IdpConfig.PhoneBuilder().build(),
    new AuthUI.IdpConfig.AnonymousBuilder().build()
     */
    override fun signInWithAuthConfig(context: AppCompatActivity, requestCode: Int, methods: ArrayList<AuthUI.IdpConfig>) {
        context.startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(
                    methods
                )
                .build(),
            requestCode
        )
    }

    override fun destroyFirebaseListener() {
        this.listener = null
    }

}
