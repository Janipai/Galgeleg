package com.example.rigtiggalgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.rigtiggalgeleg.Model_logik.Model_logik.Contex;
import com.example.rigtiggalgeleg.Model_logik.Model_logik.PlayingState;

public class Tabt extends AppCompatActivity implements View.OnClickListener {

    Contex ctx = Contex.getInstance();
    Button spilIgen, highscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabt);

        TextView svarVedtabt = (TextView) findViewById(R.id.textView4);
        svarVedtabt.setText("Ordet var: " + ctx.getOrdet());

        spilIgen = (Button) findViewById(R.id.spilIgen);
        spilIgen.setOnClickListener(this);

        highscore = (Button) findViewById(R.id.goToHighscore);
        highscore.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.spilIgen) {
            ctx.startNytSpil();
            Intent spil = new Intent(this, Spil.class);
            startActivity(spil);
        } else if (v.getId() == R.id.goToHighscore) {
            Intent highscore = new Intent(this, Highscore.class);
            startActivity(highscore);
        }
    }
}