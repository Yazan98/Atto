package io.atto.data

import okhttp3.Credentials
import retrofit2.Retrofit

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/29/2019
 * Time : 10:56 PM
 */

abstract class AttoRepository<Api> {

    open lateinit var retrofit: Retrofit

    open fun getServiceProvider(): Retrofit {
        return if (::retrofit.isInitialized) {
            retrofit
        } else {
            AttoRetrofitProvider.getDefaultRetrofit(getBaseUrl())
        }
    }

    protected fun getBasicAuthToken(username: String, password: String): String {
        return Credentials.basic(username, password)
    }

    protected abstract fun getBaseUrl(): String
    protected abstract fun getService(): Api

}
