package com.example.notficationkotlin

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {
    lateinit var notification:NotificationCompat.Builder
    val CHANNE_NAME:String="Notification"
    val CHANNEL_ID:String="NID"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel()
        notification =NotificationCompat.Builder(this,CHANNEL_ID)
    }
    fun getNotification(view: View){
        notification.setSmallIcon(R.drawable.notificatoin_foreground)
        notification.setTicker("Google Pay")
        notification.setWhen(System.currentTimeMillis())
        notification.setContentTitle("Manadate Created")
        notification.setContentTitle("Manadate create for NextBillionTechnology")
        notification.setAutoCancel(true)
        notification.setPriority(NotificationCompat.PRIORITY_MAX)
        var intent:Intent= Intent(this,MainActivity::class.java)
        var pi:PendingIntent = PendingIntent.getActivity(this,0,intent,0)
        notification.setContentIntent(pi)
        val nmanager=getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        nmanager.notify(101,notification.build())





    }
    fun createNotificationChannel()
    {
        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.O)
        {
           val  channel:NotificationChannel =
               NotificationChannel(CHANNEL_ID,CHANNE_NAME,NotificationManager.IMPORTANCE_DEFAULT)
           channel.description="My"
           val notificationManager:NotificationManager=getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)



        }

    }
}