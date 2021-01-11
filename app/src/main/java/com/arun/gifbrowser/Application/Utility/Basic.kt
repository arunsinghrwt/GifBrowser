package com.arun.gifbrowser.Application.Utility

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.content.res.Configuration
import android.graphics.drawable.Drawable
import android.util.DisplayMetrics
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.GridLayoutManager
import com.arun.gifbrowser.Application.Adapter.ImageAdapter
import com.arun.gifbrowser.R

/**
 *Created by Arun singh rawat on 08-01-2021.
 *https://github.com/arunsinghrwt

 */

fun Drawable.showProgressAnim(): ObjectAnimator {
    return ObjectAnimator.ofInt(this, "level", 0, 10000)
        .apply {
            repeatCount = ValueAnimator.INFINITE
            interpolator = LinearInterpolator()
            duration = 600L
            start()
        }

}

fun Context.getGridLayoutManager(
        orientationPortrait: Int,
        adapter: ImageAdapter
): GridLayoutManager {

    var spanCount = when (orientationPortrait) {
        Configuration.ORIENTATION_PORTRAIT -> 3
        Configuration.ORIENTATION_LANDSCAPE -> 4
        else -> 3
    }
    return GridLayoutManager(
            this, spanCount,
            GridLayoutManager.VERTICAL, false
    ).apply {
        spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (adapter.getItemViewType(position)) {
                    else -> 1
                }
            }
        }
    }
}
fun DisplayMetrics.getScreenSize() {
    Constants.HeightPX = heightPixels
    Constants.WidthPX = widthPixels
    Constants.DENSITY = density
}
