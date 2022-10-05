package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var number = 0
    var runnable : Runnable = Runnable {}
    var handler = Handler (Looper.myLooper()!!)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun start(view: View) {
        runnable = object : Runnable {
            override fun run() {
                number = number + 1
                textView.text = "Stopwatch: ${number}"
                handler.postDelayed(runnable,1000)
            }
        }
        handler.post(runnable)
    }
    fun stop (view: View){
        handler.removeCallbacks(runnable)
        number = number;
        textView.text = "Stopwatch :${number}"
    }
    fun restart (view: View){
        handler.removeCallbacks(runnable)
        number = 0
        textView.text = "0"
    }
}