package com.example.rundomuserapi.app.info

import android.content.Context
import com.example.rundomuserapi.app.base.BaseViewModel
import com.example.rundomuserapi.app.base.navigator.Navigator
import com.example.rundomuserapi.app.splash.SplashActivity
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext
/**
 * Created by rikmen00@gmail.com on 11.03.2020.
 */

class InfoViewModel constructor(context: Context) : BaseViewModel(), KodeinAware {
    override val kodein by closestKodein(context)
    override val kodeinContext = kcontext(context)
    private val navigator: Navigator by instance()

    fun gotoInfo(){

    }
    fun gotoDetectionNew(){
        navigator.startActivityAndFinish(SplashActivity::class.java)
      }
}