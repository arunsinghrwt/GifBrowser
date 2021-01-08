package com.arun.gifbrowser.Application.Utility

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.drawable.Drawable
import android.view.animation.LinearInterpolator
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