package com.arun.gifbrowser.Application.Utility

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.drawable.Drawable
import android.view.animation.LinearInterpolator

fun Drawable.showProgressAnim(): ObjectAnimator {
    return ObjectAnimator.ofInt(this, "level", 0, 10000)
        .apply {
            repeatCount = ValueAnimator.INFINITE
            interpolator = LinearInterpolator()
            duration = 600L
            start()
        }

}