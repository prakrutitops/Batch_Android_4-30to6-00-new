package com.example.serviceex

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class MyService :Service()
{
    override fun onCreate()
    {
        Toast.makeText(applicationContext, "created", Toast.LENGTH_SHORT).show()
        super.onCreate()
    }


    override fun onDestroy()
    {
        Log.d("Answer2","Stopped")
        Toast.makeText(applicationContext, "destroyed", Toast.LENGTH_SHORT).show()

        super.onDestroy()
    }

    override fun onStart(intent: Intent?, startId: Int)
    {
        for(i in 1..10)
        {
            Thread.sleep(1000)
            Log.d("Answer",i.toString())
        }

        //Toast.makeText(applicationContext, "started", Toast.LENGTH_SHORT).show()

        super.onStart(intent, startId)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int
    {
        Toast.makeText(applicationContext, "started2", Toast.LENGTH_SHORT).show()

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(p0: Intent?): IBinder?
    {
        Toast.makeText(applicationContext, "bind", Toast.LENGTH_SHORT).show()

        return null
    }

}