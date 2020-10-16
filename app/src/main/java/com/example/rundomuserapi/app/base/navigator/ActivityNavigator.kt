package com.uxreality.respondent.feature.base.navigator

import android.app.Activity
import com.example.rundomuserapi.app.base.navigator.Navigator

class ActivityNavigator constructor(private val activity: Activity) : Navigator() {

  override fun getActivity(): Activity = activity

}