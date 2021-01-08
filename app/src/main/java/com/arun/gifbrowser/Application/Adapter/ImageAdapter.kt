package com.arun.gifbrowser.Application.Adapter

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arun.gifbrowser.Application.Model.GifList
import com.arun.gifbrowser.R

import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.signature.ObjectKey
import kotlinx.android.synthetic.main.image_row.view.*


/**
 *Created by Arun singh rawat on 08-01-2021.
 *https://github.com/arunsinghrwt

 */
class ImageAdapter(internal val context: Context) : androidx.recyclerview.widget.RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    var list  = ArrayList<GifList>()
    private val glide: RequestManager = Glide.with(context)
    internal lateinit var imageOnClickListner: ImageOnClickListner
    interface ImageOnClickListner {
        fun imageClick(
            pos: Int,
            image: GifList
        )
    }
    fun setImageOnClickListner(imageOnClickListner: ImageOnClickListner) {
        this.imageOnClickListner = imageOnClickListner
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(LayoutInflater.from(context).inflate(R.layout.image_row,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var url: String = list[position].url
        glide.load(url)
            .placeholder(ColorDrawable(Color.GRAY))
            .error(ColorDrawable(Color.GRAY))
            .thumbnail(
                glide.load(url).override(300)
                    .transform(CenterCrop())
            )
            .transform(CenterCrop())
            .transition(DrawableTransitionOptions.withCrossFade())
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.itemView.imageView)

    }

    private fun imagebind(url: String) {



    }

    override fun getItemCount(): Int {
     return  list.size
    }
    inner class ViewHolder (view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view),
        View.OnClickListener {
        init {
               itemView.setOnClickListener(this)
               itemView.imageView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            imageOnClickListner.imageClick(adapterPosition, list[adapterPosition])
        }

        }

}

