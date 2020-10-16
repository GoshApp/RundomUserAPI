package com.example.rundomuserapi.app.base.navigator

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

abstract class Navigator {
  abstract fun getActivity(): Activity

  fun startActivityAndFinish(activityClass: Class<out AppCompatActivity>) {
    val activity = getActivity()
    val intent = Intent(activity, activityClass)
    activity.startActivity(intent)
    activity.finish()
  }



}