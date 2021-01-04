package com.example.s195477;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.s195477.Model_logik.Model_logik.Contex;
import com.example.s195477.Model_logik.Model_logik.NotPlayingState;

public class Hovedmenu extends AppCompatActivity implements View.OnClickListener {

    Button spil, multiplayerbutton, hjaelp, highscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadeout, R.anim.fadeout);
        setContentView(R.layout.hovedmenu);

        //button for singleplayer
        spil = (Button) findViewById(R.id.singleplayerbutton);
        spil.setOnClickListener(this);

        //button for multiplayer
        multiplayerbutton = (Button) findViewById(R.id.multiplayerbutton);
        multiplayerbutton.setOnClickListener(this);

        //knap for at reache hjælp
        hjaelp = (Button) findViewById(R.id.hjaelp);
        hjaelp.setOnClickListener(this);

        //knap for at se highscores
        highscore = (Button) findViewById(R.id.highscore);
        highscore.setOnClickListener(this);
    }

    private void overridePendingTransition(int fadeout) {
    }


    @Override
    public void onClick(View v) {
        //sammenligner om det id på den knap der er trykket på
        //går hen til den knaps aktivitet
        if (v.getId() == R.id.singleplayerbutton) {

            //explicit intent
            Intent svaerhed = new Intent(this, Svaerhedsgrad.class);
            //nu med animation
            startActivity(svaerhed, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

        }else if (v.getId()==R.id.multiplayerbutton){
            Intent multiplayer = new Intent(this, Multiplayer.class);
            startActivity(multiplayer);
        }else if (v.getId() == R.id.hjaelp){
            Intent hjaelp = new Intent(this, Hjaelp.class);
            startActivity(hjaelp);
        }else if (v.getId() == R.id.highscore){
            Intent highscore = new Intent(this, Highscore.class);
            startActivity(highscore);
        }
    }
}