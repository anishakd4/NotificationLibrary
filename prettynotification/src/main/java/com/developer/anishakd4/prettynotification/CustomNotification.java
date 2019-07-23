package com.developer.anishakd4.prettynotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.core.app.NotificationCompat;

import java.util.Calendar;

public class CustomNotification {

    public void simpleNotification(Context context, String title, String content, int icon){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(icon)
                .setContentText(content)
                .setContentTitle(title);

        NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(10, builder.build());
    }

    public void bigNotification(Context context, String title, String content, String bigText, String summary, int sIcon, int bIcon){

        Bitmap bImage = BitmapFactory.decodeResource(context.getResources(), bIcon);

        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        bigTextStyle.bigText(bigText);
        bigTextStyle.setSummaryText(summary);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(sIcon)
                .setLargeIcon(bImage)
                .setContentTitle(title)
                .setContentText(content)
                .setStyle(bigTextStyle);

        NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(11, builder.build());
    }

    public void inboxStyleNotification(Context context, String content, String bTitle, String title, String summary, int icon, String ... messages){

        Intent intent = new Intent(context, YOUR_ACTIVITY);
        PendingIntent pendingIntent = new PendingIntent(context, Calendar.getInstance().getTimeInMillis(), intent, 0);

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle(bTitle);
        inboxStyle.addLine(messages[0]);
        inboxStyle.addLine(messages[1]);
        inboxStyle.addLine(messages[2]);
        inboxStyle.addLine(messages[3]);
        inboxStyle.setSummaryText(summary);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(icon)
                .setContentTitle(bTitle)
                .setContentText(content)
                .setStyle(inboxStyle)
                .addAction(icon, "ActionText", pendingIntent);

        NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(12, builder.build());
    }

    public void bigPictureNotification(Context context, String title, String content, int icon, int picture){

        Bitmap bImage = BitmapFactory.decodeResource(context.getResources(), picture);

        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        bigPictureStyle.bigPicture(bImage);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(icon)
                .setContentTitle(title)
                .setContentText(content)
                .setStyle(bigPictureStyle);

        NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(13, builder.build());

    }

}
