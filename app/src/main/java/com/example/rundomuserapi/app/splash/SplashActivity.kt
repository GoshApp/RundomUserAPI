package com.example.rundomuserapi.app.splash

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.example.rundomuserapi.R
import com.example.rundomuserapi.app.base.BaseActivity
import com.example.rundomuserapi.databinding.SplashActivityBinding

class SplashActivity : BaseActivity<SplashActivityBinding, SplashViewModel>() {
  override fun getViewModelClass(): Class<SplashViewModel> = SplashViewModel::class.java

  override fun layoutId(): Int = R.layout.activity_splash

  override fun onCreate(savedInstanceState: Bundle?) {
    fullScreen()
    super.onCreate(savedInstanceState)
    viewModel.gotoSplash()
  }

  private fun fullScreen() {
    requestWindowFeature(Window.FEATURE_NO_TITLE)
    this.window.setFlags(
        WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN
    )
  }
}