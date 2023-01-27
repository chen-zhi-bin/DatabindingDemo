package com.program.databindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.program.databindingdemo.databinding.ActivityMainBinding
import com.program.databindingdemo.domain.Gender
import com.program.databindingdemo.domain.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //获取binding，有利binding，就可以给里面的字段设置相关内容
//        val binding = ActivityMainBinding.inflate(layoutInflater)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        //对于view层，它关心的是view，获取到view
        binding.user = User("张三",30,Gender.Male)
//        setContentView(binding.root)

        
    }
}