package com.example.receiverex

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var receiver = MyReceiver()
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(receiver,filter)

    }
}