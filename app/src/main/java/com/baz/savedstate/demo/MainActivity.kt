package com.baz.savedstate.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateVMFactory
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.LazyThreadSafetyMode.NONE

internal class MainActivity : AppCompatActivity() {

    val viewModel by lazy(NONE) { ViewModelProvider(this, SavedStateVMFactory(this)).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            viewModel.generateRandomNumber()
        }
        viewModel.randomNumberLiveData.observe(this, Observer {
            textView.text = "$it"
        })
    }
}
