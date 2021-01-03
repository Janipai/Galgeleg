package com.example.s195477;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Multiplayer extends AppCompatActivity implements View.OnClickListener {

    Button selvValgtOrd, twoplayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer);

        selvValgtOrd = (Button) findViewById(R.id.selvValgtOrd);
        twoplayers = (Button) findViewById(R.id.twoplayers);

        selvValgtOrd.setOnClickListener(this);
        twoplayers.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.selvValgtOrd) {
            Intent selvValgtOrd = new Intent(this, SelvValgtOrd.class);
            startActivity(selvValgtOrd);
        } else if (v.getId() == R.id.twoplayers) {
            Intent difficulty = new Intent(this, Svaerhedsgrad.class);
            startActivity(difficulty);
        }
    }
}