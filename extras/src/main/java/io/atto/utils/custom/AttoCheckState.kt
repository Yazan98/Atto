package io.atto.utils.custom

import io.atto.android.AttoConsts
import io.atto.android.Platform
import io.atto.android.PlatformValidator

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/31/2019
 * Time : 11:42 AM
 */

class AttoCheckState : PlatformValidator() {
    override fun getPlatforms(): ArrayList<Platform> {
        return arrayListOf(
            Platform("io.atto.android.rx.RxProvider" , AttoConsts.CORE_MISSING),
            Platform("io.atto.data.AttoRepository" , AttoConsts.DATA_MISSING),
            Platform("io.atto.logic.AttoRxViewModel" , AttoConsts.LOGIC_MISSING),
            Platform("io.atto.permissions.AttoPermission" , AttoConsts.PERMISSIONS_MISSING),
            Platform("io.atto.ui.base.AttoFragment" , AttoConsts.UI_MISSING),
            Platform("io.reactivex.Observable" , AttoConsts.RXJAVA_MISSING)
        )
    }
}