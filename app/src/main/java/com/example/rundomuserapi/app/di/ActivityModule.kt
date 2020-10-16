package com.example.rundomuserapi.app.di

import androidx.lifecycle.ViewModelProvider
import com.uxreality.respondent.feature.base.navigator.ActivityNavigator
import com.example.rundomuserapi.app.base.navigator.Navigator
import com.example.rundomuserapi.app.utils.ViewModelFactory
import org.kodein.di.Kodein.Module
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

private const val MODULE_NAME = "Activity Module"

val activityModule = Module(MODULE_NAME, false) {
  bind<Navigator>() with singleton { ActivityNavigator(instance()) }
  bind<ViewModelProvider.Factory>() with singleton { ViewModelFactory(instance("ActivityContext")) }
}