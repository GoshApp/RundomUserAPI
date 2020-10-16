package com.example.rundomuserapi.app.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rundomuserapi.app.splash.SplashViewModel
import com.example.rundomuserapi.app.info.InfoViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(private val context: Context): ViewModelProvider.Factory {
  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    if(modelClass.isAssignableFrom(SplashViewModel::class.java)) {
      return SplashViewModel(context) as T
    }else if(modelClass.isAssignableFrom(InfoViewModel::class.java)) {
      return InfoViewModel(context) as T
    }
      throw IllegalArgumentException("Unknown class name")
    }
}