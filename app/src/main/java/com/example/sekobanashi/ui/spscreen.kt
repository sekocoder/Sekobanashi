package com.example.sekobanashi.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.sekobanashi.R

class spscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spscreen)

        Handler().postDelayed({
            val intent = Intent(this,LogReg::class.java)
            startActivity(intent)
            finish()
        },800)
    }
}