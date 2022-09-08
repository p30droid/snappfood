package com.navin.snappfood.config

import android.app.Application
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.initialization.InitializationStatus
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener

class AppConfiguration : Application() {

    override fun onCreate() {
        super.onCreate()

        MobileAds.initialize(applicationContext , object  : OnInitializationCompleteListener{
            override fun onInitializationComplete(p0: InitializationStatus) {

            }

        })
    }

}