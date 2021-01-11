package com.arun.gifbrowser.Application.Adapter

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arun.gifbrowser.Application.Model.GifList
import com.arun.gifbrowser.Application.Utility.GlideRequests
import com.arun.gifbrowser.R
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions


import kotlinx.android.synthetic.main.image_row.view.*


/**
 *Created by Arun singh rawat on 08-01-2021.
 *https://github.com/arunsinghrwt

 */
class ImageAdapter(var glideRequests: GlideRequests, internal val context: Context) : androidx.recyclerview.widget.RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    var list  = ArrayList<GifList>()

       internal  lateinit var imageOnClick: ImageOnClick
    interface ImageOnClick {
        fun imageClick(
                pos: Int,
                image: GifList
        )
    }
    fun setImageOnClick(imageOnClick: ImageOnClick) {
        this.imageOnClick = imageOnClick
    }


    fun addList(gifArrayList: ArrayList<GifList>) {
        Log.e("Add first", "first " + gifArrayList.size)
        this.list.addAll(gifArrayList)
        notifyDataSetChanged()
    }


    fun removeList(){
        val leadStatusItem = GifList()
        this.list.removeAll(listOf(leadStatusItem))
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(LayoutInflater.from(context).inflate(R.layout.image_row, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var url: String = list[position].images.original.url
        Log.e("url", "---->>>$url")

        try {
            glideRequests.load(url)
                    .placeholder(ColorDrawable(Color.GRAY))
                    .error(ColorDrawable(Color.GRAY))
                    .thumbnail(glideRequests.load(url).override(300).transform(CenterCrop()))
                    .transform(CenterCrop())
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.itemView.imageView)
        }catch (ex: Exception){
            Log.e("ex", "--->>" + ex)
        }


    }

    override fun getItemCount(): Int {
     return  list.size
    }
    inner class ViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view),
        View.OnClickListener {
        init {
               itemView.setOnClickListener(this)
               itemView.imageView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            imageOnClick.imageClick(adapterPosition, list[adapterPosition])
        }

        }

}

