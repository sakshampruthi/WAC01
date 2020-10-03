package com.wac01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var intentActivity: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intentActivity = Intent(this,MainActivity2::class.java)
        clickButton.setOnClickListener {
            textView.text = "Activity 1 TEXT CHANGES"
        }
    }
}