package io.atto.ui.screen

import io.atto.ui.ViewPagerAdapter
import io.atto.ui.base.AttoScreen

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/31/2019
 * Time : 11:02 AM
 */

abstract class AttoPagerScreen : AttoScreen() {

    protected fun getViewPagerAdapter(): ViewPagerAdapter {
        return ViewPagerAdapter(supportFragmentManager)
    }

}
