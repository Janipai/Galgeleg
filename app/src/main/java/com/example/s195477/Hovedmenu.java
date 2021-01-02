package com.example.s195477;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.s195477.Model_logik.Model_logik.Contex;
import com.example.s195477.Model_logik.Model_logik.NotPlayingState;

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
        multiplayerbutton.setOnClickListener(this);

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

        }else if (v.getId()==R.id.multiplayerbutton){
            // Create new fragment and transaction
            Fragment multi = new Multiplayer();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack if needed
            transaction.replace(R.id.frame_multiplayer, multi);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }else if (v.getId() == R.id.hjaelp){
            Intent hjaelp = new Intent(this, Hjaelp.class);
            startActivity(hjaelp);
        }else if (v.getId() == R.id.highscore){
            Intent highscore = new Intent(this, Highscore.class);
            startActivity(highscore);
        }
    }
}