package com.example.practicews.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.practicews.R;

public class NotificationActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "My Channel";
    private static final int NOTIFICATION_ID = 100;
    private static final int REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        //Drawable to Bitmap
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.paytm, null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeIcon = bitmapDrawable.getBitmap();


        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //png image use necessary
        Notification notification;

        Intent iNotify = new Intent(getApplicationContext(), LottieAnimation.class);
        iNotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // clear previous notification after click notification

        PendingIntent pendingIntent = PendingIntent.getActivity(NotificationActivity.this, REQ_CODE, iNotify, PendingIntent.FLAG_UPDATE_CURRENT); //FLAG_UPDATE_CURRENT does not create multiple instance Notification .that will do merge notification.

        //Big Picture style
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .bigPicture(((BitmapDrawable) (ResourcesCompat.getDrawable(getResources(), R.drawable.animal, null))).getBitmap()) //Convert drawable to Bitmap
                .bigLargeIcon(largeIcon)
                .setBigContentTitle("Image sent by Aman")
                .setSummaryText("Image Message");

        //Inbox Style
        //when notification drag then show all notification
        Notification.InboxStyle inboxStyle = new Notification.InboxStyle();
        inboxStyle.addLine("A")
                .addLine("B")
                .addLine("C")
                .addLine("E")
                .addLine("D")
                .addLine("F")
                .addLine("G")
                .addLine("H")
                .addLine("I")
                .addLine("J")
                .setBigContentTitle("Full Message")
                .setSummaryText("Message from Raman"); //not showing after android 10

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new Notification.Builder(NotificationActivity.this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.app_icon)
                    .setContentText("Aman Completed 10000 coins")
                    .setSubText("New Message")
                    .setChannelId(CHANNEL_ID)
                    .setStyle(bigPictureStyle)  //set style
                    .setContentIntent(pendingIntent)  //set click on the notification
//                    .setAutoCancel(false)
                    .setOngoing(true) // when use setAutoCancel doesn't work.
                    .build();
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "New Channel", NotificationManager.IMPORTANCE_HIGH));
        } else {
            notification = new Notification.Builder(NotificationActivity.this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.app_icon)
                    .setContentText("New Message")
                    .setSubText("Aman Completed 10000 coins")
                    .setStyle(bigPictureStyle)
//                    .setAutoCancel(false)
                    .setOngoing(true)
                    .build();
        }
        nm.notify(NOTIFICATION_ID, notification);
    }
}