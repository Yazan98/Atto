package io.atto.ui.fragment

import io.atto.ui.ViewPagerAdapter
import io.atto.ui.base.AttoFragment

/**
 * Copyright (C) 2019 Atto IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/31/2019
 * Time : 11:03 AM
 */

abstract class AttoPagerFragment : AttoFragment() {

    protected fun getViewPagerAdapter(): ViewPagerAdapter {
        return ViewPagerAdapter(activity!!.supportFragmentManager)
    }

}
