package io.atto.utils.firebase

import com.google.firebase.messaging.FirebaseMessagingService

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/31/2019
 * Time : 11:34 AM
 */

abstract class AttoFirebaseMessagingService : FirebaseMessagingService() {

    protected abstract fun getNotification(): AttoNotification

}
