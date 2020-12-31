package com.example.rigtiggalgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rigtiggalgeleg.Model_logik.Model_logik.Contex;
import com.example.rigtiggalgeleg.Model_logik.Model_logik.NotPlayingState;

public class Hovedmenu extends AppCompatActivity implements View.OnClickListener {

    Contex ctx = Contex.getInstance();
    Button spil, multiplayerbutton, hjaelp, highscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hovedmenu);

        //button for singleplayer
        spil = (Button) findViewById(R.id.spil);
        spil.setOnClickListener(this);

        //button for multiplayer
        multiplayerbutton = (Button) findViewById(R.id.multiplayerbutton);

        //knap for at reache hjælp
        hjaelp = (Button) findViewById(R.id.hjaelp);
        hjaelp.setOnClickListener(this);

        //knap for at se highscores
        highscore = (Button) findViewById(R.id.highscore);
        highscore.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        //sammenligner om det id på den knap der er trykket på
        //går hen til den knaps aktivitet
        if (v.getId() == R.id.spil) {

            //explicit intent
            Intent spil = new Intent(this, Spil.class);
            startActivity(spil);
            ctx.changeState(new NotPlayingState());

        } else if (v.getId() == R.id.hjaelp){
            Intent hjaelp = new Intent(this, Hjaelp.class);
            startActivity(hjaelp);
        }else if (v.getId() == R.id.highscore){
            Intent highscore = new Intent(this, Highscore.class);
            startActivity(highscore);
        }
    }
}