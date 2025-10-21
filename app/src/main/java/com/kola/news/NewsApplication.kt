package com.kola.news

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class NewsApplication : Application(), ImageLoaderFactory {


    override fun onCreate() {
        super.onCreate()
    }

    override fun newImageLoader(): ImageLoader {
        TODO("Not yet implemented")
    }
}