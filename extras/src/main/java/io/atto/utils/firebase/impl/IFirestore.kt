package io.atto.utils.firebase.impl

import io.atto.utils.listeners.FirestoreListener

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 11:31 PM
 */

interface IFirestore {

    fun createDocument(collectionName: String , documentName: String , data: Map<String , Any>)

    fun deleteDocument(collectionName: String , documentName: String)

    fun updateDocument(collectionName: String , documentName: String , data: Map<String , Any>)

    fun getAllDocumentsInCollection(collectionName: String , listener: FirestoreListener)

}