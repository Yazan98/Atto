package io.atto.utils.listeners

import android.telephony.SmsMessage

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 9/6/2019
 * Time : 2:18 AM
 */

interface AttoSmsListener {

    fun onMessageReceive(messages: Array<SmsMessage>)

}
