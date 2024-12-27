package com.example.projectex1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class SplashScreenActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalsh)


        Handler().postDelayed(Runnable {

            var i = Intent(applicationContext, LoginActivity::class.java)
            startActivity(i)
        },3000)
    }
}