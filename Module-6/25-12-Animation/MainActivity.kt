package com.example.animationex

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.Animation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
//import com.google.android.material.animation.AnimationUtils


class MainActivity : AppCompatActivity()
{
    lateinit var img:ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img = findViewById(R.id.img)
        animatedata()
    }

    private fun animatedata()
    {
        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.blink)
        img.startAnimation(animation)
    }



}
