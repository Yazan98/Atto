package io.atto.utils.ui

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.common.ResizeOptions
import com.facebook.imagepipeline.request.ImageRequestBuilder
import com.squareup.picasso.Picasso

/**
 * Copyright (C) 2019 AttoImageLoaders IO
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 8/30/2019
 * Time : 11:22 PM
 */

object AttoImageLoaders {

    fun loadImageWithPicasso(url: String, image: ImageView) {
        Picasso.get()
            .load(url)
            .into(image)
    }

    fun loadImageWithFresco(url: String, image: SimpleDraweeView) {
        image.setImageURI(Uri.parse(url))
    }

    fun loadLargeImageWithFresco(url: String, image: SimpleDraweeView, width: Int, height: Int) {
        val request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
            .setResizeOptions(ResizeOptions(width, height))
            .build()
        image.controller = Fresco.newDraweeControllerBuilder()
            .setOldController(image.controller)
            .setImageRequest(request)
            .build()
    }

}