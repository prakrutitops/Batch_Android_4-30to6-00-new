package com.example.receiverex

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver()
{
    override fun onReceive(context: Context?, p1: Intent?)
    {
        if(p1!!.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED))
        {
            Toast.makeText(context,"Airplance Mode changed",Toast.LENGTH_LONG).show()
        }
    }

}