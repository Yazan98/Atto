package io.atto.android.usecase

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/29/2019
 * Time : 10:20 PM
 */

sealed class AttoUseCase<Request, Params, Result> : AttoUseCaseImpl<Request, Params, Result> {
    abstract class ReactiveUseCase<Request, Params> : AttoUseCase<Request, Params, Request>()
    abstract class DatabaseUseCase<Value , ID> : AttoDatabaseUseCaseImpl<Value , ID>
    interface PrefsUseCase {
        fun validateParam(param: Any)
        fun getSharedPrefrences(key: String, defVal: Any): Any
        fun saveSharedPrefrences(key: String , value: Any)
    }
}
