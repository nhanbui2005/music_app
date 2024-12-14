package com.example.client.service_notification;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.example.client.R;

public class MusicService extends Service {
    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setLooping(true);
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    "MusicChannel",
                    "Music Service Channel",
                    NotificationManager.IMPORTANCE_LOW
            );

            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(serviceChannel);
            }
        }
    }

    @SuppressLint("ForegroundServiceType")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            int command = intent.getIntExtra("command", 0); // Default command is 0

            switch (command) {
                case 1:
                    // Start playing new music
                    String audioUrlStart = intent.getStringExtra("audio_url");
                    if (audioUrlStart != null) {
                        playMusic(audioUrlStart);
                    }
                    break;

                case 2:
                    // Use the currently playing music
                    if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
                        mediaPlayer.start(); // Resume music
                    }
                    break;

                case 3:
                    // Continue playing currently paused music
                    if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                        mediaPlayer.pause(); // Pause music
                    }
                    break;

                default:
                    // Unknown command
                    break;
            }
        }

        Notification notification = new NotificationCompat.Builder(this, "MusicChannel")
                .setContentTitle("Đang phát nhạc")
                .setContentText("Nhạc nền đang phát")
                .setSmallIcon(R.drawable.icon_check_primary)
                .build();

        startForeground(1, notification);
        return START_STICKY;
    }

    private void playMusic(String audioUrl) {
        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(audioUrl);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        stopForeground(true);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
