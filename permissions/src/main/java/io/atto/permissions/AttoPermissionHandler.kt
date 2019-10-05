package io.atto.permissions

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 11:47 PM
 */

interface AttoPermissionHandler {

    fun onPermissionSuccess(permissionName: String)

    fun onPermissionDenide(permissionName: String)

}
