package io.atto.utils.utils

import android.webkit.WebView
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager

/**
 * Copyright (C) 2019 AttoImageLoaders IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 11:01 PM
 */

object AttoBackPressedUtils {

    fun getViewPagerHandler(viewpager: ViewPager, context: FragmentActivity) {
        if (viewpager.currentItem == 0) {
            context.onBackPressed()
        } else {
            viewpager.currentItem = viewpager.currentItem - 1
        }
    }

    fun handleWebViewBack(webView: WebView, context: FragmentActivity) {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            context.onBackPressed()
        }
    }

}