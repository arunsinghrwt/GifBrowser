package com.arun.gifbrowser.Application.Activity

import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.arun.gifbrowser.Application.Model.GifList
import com.arun.gifbrowser.Application.Utility.Constants
import com.arun.gifbrowser.Application.Utility.GlideApp
import com.arun.gifbrowser.Application.Utility.GlideRequests
import com.arun.gifbrowser.R
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.android.synthetic.main.activity_single_image.*

/**
 *Created by Arun singh rawat on 10-01-2021.
 *https://github.com/arunsinghrwt

 */



class SingleImageActivity : AppCompatActivity() {

    private val IMAGES_TAG = "images_tag"
    var giflist: GifList? = null
    var height : Int = 0
    var width : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_image)
        var glideRequests: GlideRequests = GlideApp.with(this)
        initialise(glideRequests)
    }

    private fun initialise(glideRequests: GlideRequests) {

        giflist = intent.getSerializableExtra(IMAGES_TAG) as GifList?
        back.setOnClickListener { finish() }
        height = giflist!!.images.original.height.toInt()
        width = giflist!!.images.original.width.toInt()
        setData(giflist!!)
        singleImageView.post(Runnable {
            val lp: ViewGroup.LayoutParams = singleImageView.layoutParams
            lp.width = Constants.WidthPX
            lp.height = (height * lp.width) / width
            singleImageView.layoutParams = lp
            singleImageView.requestLayout()
        })

        glideRequests.load(giflist!!.images.original.url)
                .placeholder(ColorDrawable(Color.GRAY))
                .error(ColorDrawable(Color.GRAY))
                .thumbnail(0.5f)
                .transition(DrawableTransitionOptions.withCrossFade())
                .skipMemoryCache(true)
                .into(singleImageView)


    }

    private fun setData(list: GifList) {
        title_text.text = list.title
        rating_text.text = list.rating
        height_text.text = height.toString()
        weight_text.text = width.toString()
        size_text.text = list.type


    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        var mwidth = 0
        when (newConfig.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> {
                mwidth = Constants.WidthPX
            }
            Configuration.ORIENTATION_LANDSCAPE -> {
                mwidth = Constants.HeightPX
            }
        }
        if (singleImageView == null) {
            return
        }
        val finalWidth = mwidth
        singleImageView.post(Runnable {
            val lp: ViewGroup.LayoutParams = singleImageView.layoutParams
            lp.width = finalWidth
            lp.height = height * lp.width / width
            singleImageView.layoutParams = lp
            singleImageView.requestLayout()
        })


    }
}