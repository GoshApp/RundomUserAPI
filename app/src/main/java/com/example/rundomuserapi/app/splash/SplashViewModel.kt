package com.example.rundomuserapi.app.splash

import android.content.Context
import android.os.Handler
import com.example.rundomuserapi.app.base.BaseViewModel
import com.example.rundomuserapi.app.base.navigator.Navigator
import com.example.rundomuserapi.app.info.InfoActivity
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext

class SplashViewModel constructor(context: Context) : BaseViewModel(), KodeinAware {
  override val kodein by closestKodein(context)
  override val kodeinContext = kcontext(context)

  private val navigator: Navigator by instance()

  fun gotoSplash() {
    Handler().postDelayed({
        // temp
      navigator.startActivityAndFinish(InfoActivity::class.java)
     // navigator.startActivityAndFinish(CalibrationStatusActivity::class.java)
              // navigator.startActivityAndFinish(VideoActivity::class.java)
    }, 2000)
  }
}