package com.example.rigtiggalgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Hovedmenu extends AppCompatActivity implements View.OnClickListener {

    Button spil, hjaelp, highscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hovedmenu);

        spil = (Button) findViewById(R.id.spil);
        spil.setOnClickListener(this);

        hjaelp = (Button) findViewById(R.id.hjaelp);
        hjaelp.setOnClickListener(this);

        highscore = (Button) findViewById(R.id.highscore);
        highscore.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.spil) {
            //explicit intent
            Intent spil = new Intent(this, Spillet.class);
            startActivity(spil);
        } else if (v.getId() == R.id.hjaelp){
            Intent hjaelp = new Intent(this, Hjaelp.class);
            startActivity(hjaelp);
        }else if (v.getId() == R.id.highscore){
            Intent highscore = new Intent(this, Highscore.class);
            startActivity(highscore);
        }
    }
}