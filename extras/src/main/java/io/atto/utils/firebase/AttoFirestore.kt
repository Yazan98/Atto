package io.atto.utils.firebase

import com.google.firebase.firestore.FirebaseFirestore
import io.atto.utils.firebase.impl.IFirestore
import io.atto.utils.listeners.FirestoreListener

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 11:31 PM
 */

class AttoFirestore : IFirestore {

    override fun createDocument(collectionName: String, documentName: String, data: Map<String, Any>) {
        FirebaseFirestore.getInstance().collection(collectionName).document(documentName).set(data)
    }

    override fun deleteDocument(collectionName: String, documentName: String) {
        FirebaseFirestore.getInstance().collection(collectionName).document(documentName).delete()
    }

    override fun updateDocument(collectionName: String, documentName: String, data: Map<String, Any>) {
        FirebaseFirestore.getInstance().collection(collectionName).document(documentName).update(data)
    }

    override fun getAllDocumentsInCollection(collectionName: String, listener: FirestoreListener) {
        val list = ArrayList<String>()
        FirebaseFirestore.getInstance().collection(collectionName).get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                for (document in task.result!!) {
                    list.add(document.id)
                }
                listener.onSuccess(list)
            } else {
                listener.onError(task.exception!!.message!!)
            }
        }
    }

}
