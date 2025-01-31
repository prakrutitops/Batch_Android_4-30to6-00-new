package com.example.fcmex

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.text.TextUtils
import android.util.Log
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.example.fcmex.MainActivity
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService()
{
    override fun onMessageReceived(message: RemoteMessage)
    {
        super.onMessageReceived(message)

        FirebaseMessaging.getInstance().token
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    if (task.result != null && !TextUtils.isEmpty(task.result))
                    {
                        val token: String = task.result!!
                        Log.d("REG_TOKEN", token)
                    }
                }
            }

        if(message.notification!=null)
        {
            showNotification(message.getNotification()!!.getTitle(), message.getNotification()!!.getBody())
        }

    }

    private fun showNotification(title: String?, body: String?)
    {
        var i = Intent(applicationContext, MainActivity::class.java)
        var n_c_i="notification_channel"
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        var pi = PendingIntent.getActivity(applicationContext,0,i,PendingIntent.FLAG_IMMUTABLE)


        var builder = NotificationCompat.Builder(this, n_c_i)
        builder.setSmallIcon(R.mipmap.ic_launcher)
        builder.setAutoCancel(true)
        builder.setVibrate(longArrayOf(1000, 1000, 1000, 1000, 1000))
        builder.setOnlyAlertOnce(true)
        builder.setContentIntent(pi)

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN)
        {
            builder = builder.setContent(getCustomDesign(title, body))
        }
        else
        {
            builder = builder.setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.mipmap.ic_launcher)
        }

        var notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            val notificationChannel = NotificationChannel(n_c_i, "web_app", NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
        }
        notificationManager.notify(0, builder.build())


    }

    @SuppressLint("RemoteViewLayout")
    private fun getCustomDesign(title: String?, body: String?): RemoteViews?
    {
        var remoteViews = RemoteViews(applicationContext.packageName,R.layout.notification)
        remoteViews.setTextViewText(R.id.title,title)
        remoteViews.setTextViewText(R.id.message,body)
        remoteViews.setImageViewResource(R.id.icon,R.mipmap.ic_launcher)
        return  remoteViews
    }

}