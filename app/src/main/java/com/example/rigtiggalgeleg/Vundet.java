package com.example.rigtiggalgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Vundet extends AppCompatActivity implements View.OnClickListener {

    Button spilIgen, highscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vundet);

        spilIgen = (Button) findViewById(R.id.spilIgen2);
        spilIgen.setOnClickListener(this);

        highscore = (Button) findViewById(R.id.goToHighscore2);
        highscore.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.spilIgen2){
            Intent spil = new Intent(this, Spil.class);
            startActivity(spil);
        }
        else if (v.getId()==R.id.goToHighscore2){
            Intent highscore = new Intent(this, Highscore.class);
            startActivity(highscore);
        }
    }
}