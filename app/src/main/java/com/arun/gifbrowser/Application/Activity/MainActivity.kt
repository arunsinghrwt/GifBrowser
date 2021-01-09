package com.arun.gifbrowser.Application.Activity

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.arun.gifbrowser.Application.Adapter.ImageAdapter
import com.arun.gifbrowser.Application.Model.GifList
import com.arun.gifbrowser.Application.Model.ViewModelGif
import com.arun.gifbrowser.Application.Network.PbrBtn
import com.arun.gifbrowser.Application.Utility.GlideApp
import com.arun.gifbrowser.Application.Utility.getGridLayoutManager
import com.arun.gifbrowser.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 *Created by Arun singh rawat on 08-01-2021.
 *https://github.com/arunsinghrwt

 */

class MainActivity : AppCompatActivity(), ImageAdapter.ImageOnClick {

    val mainModel by viewModel<ViewModelGif>()
    private lateinit var imageAdapter: ImageAdapter
    private lateinit var manager: GridLayoutManager
    val pbr by inject<PbrBtn>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //resources.displayMetrics.getScreenSize()
        initView()

        initAdapter()
        initObservers()

    }

    private fun initView() {
        pbr.init(myView)
        pbr.start()
        mainModel.getGifImageList()
    }

    private fun initObservers() {

    mainModel.mediatorGifList.observe(this , Observer {
      if (!it.isNullOrEmpty()){
          pbr.cancel()
          imageAdapter.addList(it)
      }
    })
    }

    private fun initAdapter() {

        val glide = GlideApp.with(this)
        imageAdapter = ImageAdapter(glide , applicationContext )
        imageAdapter.setImageOnClick(this)
        manager = getGridLayoutManager(Configuration.ORIENTATION_PORTRAIT, imageAdapter)
        main_recycle.apply {
            layoutManager = manager
            adapter = imageAdapter
        }
        imageAdapter.imageOnClick  = this

    }
    override fun imageClick(pos: Int, image: GifList) {
      Toast.makeText(baseContext , "heyyy", Toast.LENGTH_SHORT).show()
    }
}