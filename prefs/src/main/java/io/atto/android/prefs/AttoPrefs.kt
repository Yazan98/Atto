package io.atto.android.prefs

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 11:52 PM
 */

class AttoPrefs : AttoPrefsImplementor {

    private val repos: CompositeDisposable by lazy { CompositeDisposable() }

    override operator fun <T : Any> get(key: String, defValue: T, listener: DisposableObserver<T>?) {
        if (!AttoPrefsConfig.checkStatus()) {
            throw AttoPrefsException()
        }
        repos.add(
            getObservable(key, defValue)
                .subscribe(
                    {
                        listener!!.onNext(it)
                    },
                    {
                        listener!!.onError(it)
                    }, {
                        listener!!.onComplete()
                    }
                )
        )
    }

    override fun <T : Any> getObservable(key: String, defValue: T): Observable<T> {
        if (!AttoPrefsConfig.checkStatus()) {
            throw AttoPrefsException()
        }
        return Observable.fromCallable {
            when (defValue) {
                is Boolean -> AttoPrefsConfig.prefs.getBoolean(key, defValue) as T
                is Float -> AttoPrefsConfig.prefs.getFloat(key, defValue) as T
                is Int -> AttoPrefsConfig.prefs.getInt(key, defValue) as T
                is Long -> AttoPrefsConfig.prefs.getLong(key, defValue) as T
                is String -> AttoPrefsConfig.prefs.getString(key, defValue) as T
                else -> throw UnsupportedOperationException("no accessor found for type ${defValue::class.java}")
            }
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    @SuppressLint("CheckResult")
    override suspend fun put(key: String, value: Any) {
        withContext(Dispatchers.IO) {
            if (!AttoPrefsConfig.checkStatus()) {
                throw AttoPrefsException()
            }
            when (value) {
                is String -> {
                    AttoPrefsConfig.prefs.edit().putString(key, value).apply()
                }
                is Int -> {
                    AttoPrefsConfig.prefs.edit().putInt(key, value).apply()
                }
                is Long -> {
                    AttoPrefsConfig.prefs.edit().putLong(key, value).apply()
                }
                is Float -> {
                    AttoPrefsConfig.prefs.edit().putFloat(key, value).apply()
                }
                is Boolean -> {
                    AttoPrefsConfig.prefs.edit().putBoolean(key, value).apply()
                }
                else -> throw UnsupportedOperationException("This Type is Not Supported At Slash Prefs")
            }
        }
    }

    override fun destroy() {
        this.repos.clear()
    }

}
