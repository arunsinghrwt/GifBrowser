package com.arun.gifbrowser.Application.Activity

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.arun.gifbrowser.Application.Adapter.ImageAdapter
import com.arun.gifbrowser.Application.Model.GifList
import com.arun.gifbrowser.Application.Model.ViewModelGif
import com.arun.gifbrowser.Application.Network.PbrBtn
import com.arun.gifbrowser.Application.Utility.EndlessRecyclerViewScrollListener
import com.arun.gifbrowser.Application.Utility.GlideApp
import com.arun.gifbrowser.Application.Utility.getGridLayoutManager
import com.arun.gifbrowser.Application.Utility.getScreenSize
import com.arun.gifbrowser.R
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 *Created by Arun singh rawat on 08-01-2021.
 *https://github.com/arunsinghrwt

 */

class MainActivity : AppCompatActivity(), ImageAdapter.ImageOnClick,
    AppBarLayout.OnOffsetChangedListener, SwipeRefreshLayout.OnRefreshListener {

    val mainModel by viewModel<ViewModelGif>()
    private lateinit var imageAdapter: ImageAdapter
    private lateinit var manager: GridLayoutManager
    val pbr by inject<PbrBtn>()
    private val IMAGES_TAG = "images_tag"
    private var loading = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resources.displayMetrics.getScreenSize()
        initView()
        initAdapter()
        initObservers()

    }

    private fun initView() {
        myView.visibility = View.GONE
        pbrMainView.visibility = View.VISIBLE
        pbr.init(pbrView)
        pbr.start()
        mainModel.getGifImageList()
    }

    private fun initObservers() {
        mainModel.mediatorGifList.observe(this, Observer {
            swipe_refresh.isRefreshing = false
            if (!it.isNullOrEmpty()) {
                pbr.cancel()
                myView.visibility = View.VISIBLE
                pbrMainView.visibility = View.GONE
                imageAdapter.addList(it)
            }
        })
    }

    private fun initAdapter() {
        val glide = GlideApp.with(this)
        swipe_refresh.setOnRefreshListener(this)
        imageAdapter = ImageAdapter(glide, applicationContext)
        imageAdapter.setImageOnClick(this)
        manager = getGridLayoutManager(Configuration.ORIENTATION_PORTRAIT, imageAdapter)
        main_recycle.apply {
            layoutManager = manager
            adapter = imageAdapter
        }

        main_recycle.addOnScrollListener(object : EndlessRecyclerViewScrollListener(manager){
           override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
               Log.e("onLoadMore","page ->$page    totalItemsCount-> $totalItemsCount")
               if (loading) {
                   if (page == 10){
                       loading = false
                   }
                   swipe_refresh.isRefreshing = true
                   mainModel.getGifImageList()
               } }
        })
        imageAdapter.imageOnClick  = this
    }
    override fun imageClick(pos: Int, image: GifList) {
        setActivity(image)
    }



    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        var manager = getGridLayoutManager(newConfig.orientation, imageAdapter)
        main_recycle.layoutManager = manager
    }


    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        //The Refresh must be only active when the offset is zero :
        swipe_refresh.isEnabled = verticalOffset == 0
    }



    override fun onResume() {
        super.onResume()
        appBarLayout.addOnOffsetChangedListener(this)
    }

    override fun onPause() {
        super.onPause()
        appBarLayout.removeOnOffsetChangedListener(this)
    }
    private fun setActivity(image: GifList) {
        var intent  = Intent(applicationContext, SingleImageActivity::class.java)
        intent.putExtra(IMAGES_TAG, image)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation( this).toBundle())
        } else {
         startActivity(intent)
        }
    }

    override fun onRefresh() {
        imageAdapter.removeList()
        mainModel.getGifImageList()

    }


}