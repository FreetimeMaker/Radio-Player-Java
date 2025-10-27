package com.freetime.rpj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private ExoPlayer exoPlayer;
    private final String sunshineUrl = "https://chmedia.streamabc.net/79-rsunshine-mp3-192-4746851?sABC=68s562rr%231%231699795900047_8633080%23puzrqvn-enqvb-jro&aw_0_1st.playerid=chmedia-radio-web&amsparams=playerid:chmedia-radio-web;skey:1760912110"; // replace with real stream
    private final String argoviaUrl = "https://chmedia.streamabc.net/79-argovia-mp3-192-3024993?sABC=68s5qo3r%230%23q7s809s74070n543n7p5213q6qr39235%23qverpg&aw_0_1st.playerid=direct&amsparams=playerid:direct;skey:1760942910"; // replace with real stream
    private final String pilatusUrl = "https://chmedia.streamabc.net/79-pilatus-mp3-192-4664468?sABC=68s5s266%230%23q7s809s74070n543n7p5213q6qr39235%23puzrqvn&aw_0_1st.playerid=chmedia&amsparams=playerid:chmedia;skey:1760948838"; // replace with real stream
    private final String srf3Url = "http://livestreaming-node-2.srg-ssr.ch/srgssr/srf3/mp3/128"; // replace with real stream
    private final String srf1Url = "http://livestreaming-node-2.srg-ssr.ch/srgssr/srf1/mp3/128"; // replace with real stream

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );

        MaterialButton SunPlayBtn = findViewById(R.id.SunPlayBTN);
        MaterialButton ArgPlayBtn = findViewById(R.id.ArgPlayBTN);
        MaterialButton PilPlayBtn = findViewById(R.id.PilPlayBTN);
        MaterialButton SRF3PlayBtn = findViewById(R.id.SRF3PlayBTN);
        MaterialButton SRF1PlayBtn = findViewById(R.id.SRF1PlayBTN);

        // Initialize ExoPlayer
        exoPlayer = new ExoPlayer.Builder(this).build();

        SunPlayBtn.setOnClickListener(v -> {
            playStream(sunshineUrl, SunPlayBtn);
            Toast.makeText(MainActivity.this, "Playing Sunshine Radio", Toast.LENGTH_SHORT).show();
        });

        ArgPlayBtn.setOnClickListener(v -> {
            playStream(argoviaUrl, ArgPlayBtn);
            Toast.makeText(MainActivity.this, "Playing Radio Argovia", Toast.LENGTH_SHORT).show();
        });

        PilPlayBtn.setOnClickListener(v -> {
            playStream(pilatusUrl, PilPlayBtn);
            Toast.makeText(MainActivity.this, "Playing Radio Pilatus", Toast.LENGTH_SHORT).show();
        });

        SRF3PlayBtn.setOnClickListener(v -> {
            playStream(srf3Url, SRF3PlayBtn);
            Toast.makeText(MainActivity.this, "Playing SRF 3", Toast.LENGTH_SHORT).show();
        });

        SRF1PlayBtn.setOnClickListener(v -> {
            playStream(srf1Url, SRF1PlayBtn);
            Toast.makeText(MainActivity.this, "Playing SRF 1", Toast.LENGTH_SHORT).show();
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
