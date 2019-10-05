package io.atto.android

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 6:19 PM
 */

object AttoConsts {
    const val EXECUTOR_HANDLER_EMPTY = "Handler Executor IS Not Initialized .. Maybe You Forget To call addHandler(this)"
    const val VIEWMODEL_VIEW_NULL = "View At ViewModel Not Attached ... Maybe You Forget To Call viewModel.setView(this)"
    const val CORE_MISSING = "Atto Core Missing At Dependencies Check Application Dependencies Before Try Again"
    const val DATA_MISSING = "Atto Data Missing At Dependencies Check Application Dependencies Before Try Again"
    const val LOGIC_MISSING = "Atto Logic Missing At Dependencies Check Application Dependencies Before Try Again"
    const val PERMISSIONS_MISSING = "Atto Permissions Missing At Dependencies Check Application Dependencies Before Try Again"
    const val UI_MISSING = "Atto UI Missing At Dependencies Check Application Dependencies Before Try Again"
    const val RXJAVA_MISSING = "RxJava Missing At Dependencies Check Application Dependencies Before Try Again"
    const val LANGUAGE_NOT_INITIALIZED = "Atto Language Toggle Not Initialized : Maybe You Forget To Implement AttoLanguageToggle.init(context)"
}
