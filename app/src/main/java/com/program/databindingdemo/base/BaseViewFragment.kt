package com.program.databindingdemo.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseViewFragment<T:ViewDataBinding>: Fragment() {

    protected lateinit var binding:T

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //view
//        val view = inflater.inflate(getSubLayoutId(), container, false)
//        val binding = DataBindingUtil.bind<T>(view)

        val binding = DataBindingUtil.inflate<T>(inflater, getSubLayoutId(), container, false)
        return binding!!.root
    }

    abstract fun getSubLayoutId():Int

}