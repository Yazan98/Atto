package io.atto.utils.ui

import android.content.Intent
import android.net.Uri
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import io.atto.utils.listeners.AttoDownloadImageListener
import io.atto.utils.listeners.AttoFirebaseImageListener

/**
 * Copyright (C) 2019 AttoImageLoaders IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 11:18 PM
 */

object FirebaseImageManager {

    private var listener: AttoFirebaseImageListener? = null
    private var downloadListener: AttoDownloadImageListener? = null

    fun chooseImage(context: FragmentActivity, requestCode: Int) {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        context.startActivityForResult(Intent.createChooser(intent, "Select Picture"), requestCode)
    }

    fun uploadImageToFirebase(imagePath: String, filePath: Uri) {
        val storage = FirebaseStorage.getInstance()
        val storageReference = storage.reference

        val ref: StorageReference = storageReference.child(imagePath)
        ref.putFile(filePath)
            .addOnSuccessListener {
                listener!!.onSuccess()
            }
            .addOnFailureListener { e ->
                listener!!.onError(e)
            }
            .addOnProgressListener { taskSnapshot ->
                val progress = 100.0 * taskSnapshot.bytesTransferred / taskSnapshot
                    .totalByteCount
                listener!!.onProgress(progress)
            }
    }

    fun downloadImageFromFirebase(imagePath: String, file: Uri) {
        val ref = FirebaseStorage.getInstance().reference.child(imagePath)
        val uploadTask = ref.putFile(file)
        uploadTask.continueWithTask(Continuation<UploadTask.TaskSnapshot, Task<Uri>> { task ->
            if (!task.isSuccessful) {
                task.exception?.let {
                    downloadListener!!.onError(task.exception!!)
                }
            }
            return@Continuation ref.downloadUrl
        }).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val downloadUri = task.result
                downloadListener!!.onSuccess(downloadUri.toString())
            } else {
                downloadListener!!.onError(task.exception!!)
            }
        }
    }

    fun setSlashImageListener(listener: AttoFirebaseImageListener?) {
        this.listener = listener
    }

    fun setDownloadImageListener(listener: AttoDownloadImageListener?) {
        this.downloadListener = listener
    }

    fun destroyImageManager() {
        listener = null
        downloadListener = null
    }

}
