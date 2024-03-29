package io.atto.utils.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Copyright (C) 2019 AttoImageLoaders IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 11:11 PM
 */

abstract class AttoBaseAdapter<VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(context).inflate(getLayoutRes(), parent, false)
        return getViewHolder(v)
    }

    protected abstract fun getLayoutRes(): Int
    protected abstract fun getViewHolder(view: View): VH

}
