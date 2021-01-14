package com.example.sevisise;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyServise extends Service {

    MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this , "Service start" , Toast.LENGTH_LONG).show();
        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_NOTIFICATION_URI);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        return super.START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this , "Service killed" , Toast.LENGTH_LONG).show();
        mediaPlayer.pause();
        super.onDestroy();
    }
}
