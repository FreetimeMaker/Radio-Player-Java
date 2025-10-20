package com.freetime.rpj;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.freetime.rpj.databinding.ActivityMainBinding;

import java.io.IOException;

import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private ExoPlayer exoPlayer;
    private final String sunshineUrl = "https://chmedia.streamabc.net/79-rsunshine-mp3-192-4746851?sABC=68s562rr%231%231699795900047_8633080%23puzrqvn-enqvb-jro&aw_0_1st.playerid=chmedia-radio-web&amsparams=playerid:chmedia-radio-web;skey:1760912110"; // replace with real stream

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialButton sunPlayBtn = findViewById(R.id.SunPlayBTN);

        // Initialize ExoPlayer
        exoPlayer = new ExoPlayer.Builder(this).build();

        sunPlayBtn.setOnClickListener(v -> {
            playStream(sunshineUrl, sunPlayBtn);
            Toast.makeText(MainActivity.this, "Playing Sunshine Radio", Toast.LENGTH_SHORT).show();
        });
    }

    private void playStream(String url, MaterialButton button) {
        MediaItem mediaItem = MediaItem.fromUri(url);
        exoPlayer.setMediaItem(mediaItem);
        exoPlayer.prepare();
        exoPlayer.play();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (exoPlayer != null) {
            exoPlayer.release();
            exoPlayer = null;
        }
    }
}
