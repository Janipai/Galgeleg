package com.example.s195477;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.s195477.Model_logik.Model_logik.Contex;
import com.example.s195477.Model_logik.Model_logik.NotPlayingState;

public class Spil extends AppCompatActivity implements View.OnClickListener {

    Contex ctx = Contex.getInstance();

    TextView word, fejltxt;
    ImageView imgview;
    Button guess;
    EditText input;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.spillet);

        ctx.startNytSpil();

        //gæt knap
        guess = (Button) findViewById(R.id.gaet);
        guess.setOnClickListener(this);

        //Ordet der skal gættes
        word = (TextView) findViewById(R.id.ordetDerGaettes);
        System.out.println(ctx.getSynligtOrd());
        word.setText("Gæt ordet: " + ctx.getSynligtOrd());

        //txt til hvilke forkertebogstaver
        fejltxt = (TextView) findViewById(R.id.fejltxt);
        fejltxt.setText("");

        //lad start score være 0
        score = getIntent().getIntExtra("Score", 0);
        ctx.setScore(score);

        //galgebillede
        imgview = (ImageView) findViewById(R.id.galgeImg);
        //input felt til bogstaver der vil gættes
        input = (EditText) findViewById(R.id.inputField);
    }

    @Override
    public void onClick(View v) {
        //status til loggen
        ctx.logStatus();

        String bogstav = input.getText().toString();

        if (bogstav.length() != 1) {
            while (bogstav.length() > 1) {
                System.out.println("Der må kun gættes på et bogstav");
                fejltxt.setText("Der må kun gættes på et bogstav");
                input.setText("");
                bogstav = input.getText().toString();
            }
        }

        if (v.getId() == R.id.gaet) {
            ctx.gætBogstav(bogstav);
            word.setText("Gæt ordet: " + ctx.getSynligtOrd());
            fejltxt.setText("Forkerte bogstaver gættet: " + ctx.getBrugteBogstaver());

            if (bogstav.length() != 1) {
                fejltxt.setText("Der må kun gættes på et bogstav");
            }
            //opdaterer galgen
            if (ctx.erSpilletVundet()) {
                Intent vundet = new Intent(this, Vundet.class);
                vundet.putExtra("Score", score);
                startActivity(vundet);
            } else if (ctx.getAntalForkerteBogstaver() == 1)
                imgview.setImageResource(R.drawable.forkert1);
            else if (ctx.getAntalForkerteBogstaver() == 2)
                imgview.setImageResource(R.drawable.forkert2);
            else if (ctx.getAntalForkerteBogstaver() == 3)
                imgview.setImageResource(R.drawable.forkert3);
            else if (ctx.getAntalForkerteBogstaver() == 4)
                imgview.setImageResource(R.drawable.forkert4);
            else if (ctx.getAntalForkerteBogstaver() == 5)
                imgview.setImageResource(R.drawable.forkert5);
            else if (ctx.getAntalForkerteBogstaver() == 6) {
                imgview.setImageResource(R.drawable.forkert6);
                ctx.changeState(new NotPlayingState());
                Intent tabt = new Intent(this, Tabt.class);
                startActivity(tabt);
            }
            if (ctx.getOrdet().contains(bogstav)) {
                score += 5;
            } else {
                if (score < 2) {
                    score = 0;
                } else {
                    score -= 2;
                }
            }
        }
        input.setText("");
    }
}