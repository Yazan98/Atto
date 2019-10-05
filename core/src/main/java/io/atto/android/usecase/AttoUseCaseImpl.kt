package io.atto.android.usecase

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/29/2019
 * Time : 10:22 PM
 */

interface AttoUseCaseImpl<Request, Params, Result> {

    fun validate(content: Params)

    fun execute(request: Request): Result

}

interface AttoDatabaseUseCaseImpl<Value, ID> {
    suspend fun createEntity(entity: Value)
    suspend fun getEntityById(id: ID): Value
    suspend fun getAllEntities(): ArrayList<Value>
    suspend fun deleteEntityById(id: ID)
    suspend fun deleteAllEntities()
}
