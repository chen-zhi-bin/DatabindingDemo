package com.program.databindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.program.databindingdemo.fragment.OnSellFragment

class TaobaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taobao)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,OnSellFragment())
            .commit()
    }
}