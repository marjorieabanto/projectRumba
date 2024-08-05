package com.example.projectrumba

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View

import android.widget.FrameLayout
import android.widget.ImageView

import androidx.appcompat.app.AppCompatActivity

import com.example.projectrumba.fragments.LogInFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val fragmentContainer = findViewById<FrameLayout>(R.id.main)
        val fondito= findViewById<ImageView>(R.id.imageView2)
        val logo= findViewById<ImageView>(R.id.imageView3)
        Handler(Looper.getMainLooper()).postDelayed({
            supportFragmentManager.beginTransaction()
                .replace(R.id.main, LogInFragment())
                .commit()
            fragmentContainer.bringToFront()
            fondito.visibility= View.GONE;
            logo.visibility= View.GONE;
        }, 5000) // 7000 milisegundos = 7 segundos
    }

}