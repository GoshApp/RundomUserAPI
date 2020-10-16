package com.example.rundomuserapi.app.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.uxreality.respondent.di.fragmentModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinContext
import org.kodein.di.android.support.closestKodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext

abstract class BaseDialogFragment<B : ViewDataBinding, VM : ViewModel> : DialogFragment(), KodeinAware {
  protected lateinit var binding: B
  lateinit var viewModel: VM

  override val kodeinContext: KodeinContext<*> get() = kcontext(activity)
  private val _parentKodein by closestKodein()

  override val kodein: Kodein = Kodein.lazy {
    extend(_parentKodein)
    import(fragmentModule)
  }

  private val viewModelFactory: ViewModelProvider.Factory by instance()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    bindContentView(inflater, layoutId(), container)
    fragmentInitialized()
    return binding.root
  }

  private fun bindContentView(inflater: LayoutInflater, layoutId: Int, container: ViewGroup?) {
    binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
    viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModelClass())
  }

  abstract fun getViewModelClass(): Class<VM>

  @LayoutRes protected abstract fun layoutId(): Int

  abstract fun fragmentInitialized()
}