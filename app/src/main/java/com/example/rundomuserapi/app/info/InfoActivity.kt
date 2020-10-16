package com.example.rundomuserapi.app.info

import android.os.Bundle
import com.example.rundomuserapi.R
import com.example.rundomuserapi.app.base.BaseActivity
import com.example.rundomuserapi.databinding.InfoActivityBinding


class InfoActivity : BaseActivity<InfoActivityBinding, InfoViewModel>() {
    override fun getViewModelClass(): Class<InfoViewModel> = InfoViewModel::class.java
    override fun layoutId(): Int = R.layout.info_activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.gotoInfo()

        binding.btnStartCalibration.setOnClickListener {
            viewModel.gotoDetectionNew()
        }

        binding.btnWatchVideo.setOnClickListener {
            //viewModel.gotoVideo()
        }
    }
}