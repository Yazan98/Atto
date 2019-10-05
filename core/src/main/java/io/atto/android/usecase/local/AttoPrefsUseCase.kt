package io.atto.android.usecase.local

import io.atto.android.prefs.AttoPrefs
import io.atto.android.usecase.AttoUseCase
import io.reactivex.observers.DisposableObserver
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 9/1/2019
 * Time : 1:17 AM
 */

abstract class AttoPrefsUseCase<Listener : DisposableObserver<Any>> : AttoUseCase.PrefsUseCase {

    private val prefs: AttoPrefs by lazy {
        AttoPrefs()
    }

    override fun getSharedPrefrences(key: String, defVal: Any): Any {
        return prefs[key, defVal, getPrefsListener()]
    }

    override fun saveSharedPrefrences(key: String, value: Any) {
        GlobalScope.launch { prefs.put(key, value) }
    }

    protected abstract fun getPrefsListener(): Listener

}
