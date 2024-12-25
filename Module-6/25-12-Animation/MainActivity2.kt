package com.example.animationex

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity()
{
   lateinit var btnStart: Button
    lateinit var imageView: ImageView
    lateinit var animationDrawable: AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnStart=findViewById(R.id.btnStart)
        imageView=findViewById(R.id.imageView)
        animationDrawable=(imageView.getBackground() as AnimationDrawable)


        btnStart.setOnClickListener {
            if (animationDrawable.isRunning) {
                animationDrawable.stop()
            } else {
                animationDrawable.start()
            }
        }
    }
}