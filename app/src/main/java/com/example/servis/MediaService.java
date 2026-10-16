package com.example.servis;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MediaService extends Service {

    private MediaPlayer ambientMediaPlayer;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ambientMediaPlayer = MediaPlayer.create(this, R.raw.music);
        ambientMediaPlayer.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (ambientMediaPlayer != null && !ambientMediaPlayer.isPlaying()) {
            ambientMediaPlayer.start();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        if (ambientMediaPlayer != null) {
            ambientMediaPlayer.stop();
            ambientMediaPlayer.release();
            ambientMediaPlayer = null;
        }
        super.onDestroy();
    }
}