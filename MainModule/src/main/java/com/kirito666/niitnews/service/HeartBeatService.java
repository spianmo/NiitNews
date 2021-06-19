package com.kirito666.niitnews.service;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.kirito666.niitnews.R;
import com.kirshi.framework.daemon.AbsHeartBeatService;


/**
 * Copyright (c) 2021
 * @Project:NiitNews
 * @Author:Finger
 * @FileName:HeartBeatService.java
 * @LastModified:2021/06/17 16:57:17
 */

/**
 * @author Finger
 */
public class HeartBeatService extends AbsHeartBeatService {
    @Override
    public void onStartService() {
        initNotificationChannel();
        buildNotification(R.drawable.ic_baseline_domain_24, getString(R.string.app_name), "NiitNews推送服务已开启");
    }

    @Override
    public void onStopService() {
    }

    @Override
    public long getDelayExecutedMillis() {
        return 0;
    }

    @Override
    public long getHeartBeatMillis() {
        return 10 * 1000;
    }

    @Override
    public void onHeartBeat() {
        Log.e("--->", "onBeat");
    }

    private static final int NOTIFICATION_ID_ICON = 1;
    private static final String UNLOCK_NOTIFICATION_CHANNEL_ID = "media_notification";

    private void initNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "NiitNews";
            String description = "推送服务";
            NotificationChannel mChannel = new NotificationChannel(UNLOCK_NOTIFICATION_CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT);
            mChannel.setDescription(description);
            mChannel.enableLights(false);
            mChannel.enableVibration(false);

            NotificationManager notificationManager = (NotificationManager) getSystemService(
                    NOTIFICATION_SERVICE);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(mChannel);
            }
        }
    }

    private void buildNotification(int resId, String title, String content) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, UNLOCK_NOTIFICATION_CHANNEL_ID);
        builder.setContentTitle(title)
                .setContentText(content)
                .setSmallIcon(resId);

        Intent notifyIntent = new Intent(this, HeartBeatService.class);
        PendingIntent notifyPendingIntent = PendingIntent.getActivity(this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(notifyPendingIntent);
        Notification notification = builder.build();
        notification.flags |= Notification.FLAG_ONGOING_EVENT;
        notification.flags |= Notification.FLAG_NO_CLEAR;

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (manager != null) {
            manager.notify(NOTIFICATION_ID_ICON, notification);
        }

        startForeground(NOTIFICATION_ID_ICON, notification);
    }
}