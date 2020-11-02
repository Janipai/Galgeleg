package com.example.rigtiggalgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Spil extends AppCompatActivity implements View.OnClickListener {

    GalgeLogik galgeLogik = new GalgeLogik();
    TextView word;
    ImageView imgview;
    Button guess;
    EditText input;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spillet);

        galgeLogik.startNytSpil();

        //gæt knap
        guess = (Button) findViewById(R.id.gaet);
        guess.setOnClickListener(this);

        //Ordet der skal gættes
        word = (TextView) findViewById(R.id.ordetDerGaettes);
        word.setText("Gæt ordet: " + galgeLogik.getSynligtOrd());

        //lad start score være 0
        score = getIntent().getIntExtra("Score", 0);
        galgeLogik.setScore(score);

        //galgebillede
        imgview = (ImageView) findViewById(R.id.galgeImg);
        //input felt til bogstaver der vil gættes
        input = (EditText) findViewById(R.id.inputField);


    }

    @Override
    public void onClick(View v) {

        //status til loggen
        galgeLogik.logStatus();

        EditText et = (EditText) findViewById(R.id.inputField);
        et.getText();

        if (v.getId()==R.id.gaet){
            spil();
        }

        et.setText("");
    }

    public void spil() {
        //laver input til string
        String bogstav = input.getText().toString();

        //sammenligner bogstav med det rigtige ord, og opdater ordet der gættes på
        galgeLogik.gætBogstav(bogstav);
        //opdatere på hvad der er gættet og mangler at blive gættet
        word.setText("Gæt ordet: " + galgeLogik.getSynligtOrd());
        //hvilke bogstaver der er gættet på
        word.append("\n Du har gættet følgende bogstaver " + galgeLogik.getBrugteBogstaver());

        //opdaterer galgen
        if (galgeLogik.getAntalForkerteBogstaver() == 1)
            imgview.setImageResource(R.drawable.forkert1);
        else if (galgeLogik.getAntalForkerteBogstaver() == 2)
            imgview.setImageResource(R.drawable.forkert2);
        else if (galgeLogik.getAntalForkerteBogstaver() == 3)
            imgview.setImageResource(R.drawable.forkert3);
        else if (galgeLogik.getAntalForkerteBogstaver() == 4)
            imgview.setImageResource(R.drawable.forkert4);
        else if (galgeLogik.getAntalForkerteBogstaver() == 5)
            imgview.setImageResource(R.drawable.forkert5);
        else if (galgeLogik.getAntalForkerteBogstaver() == 6) {
            imgview.setImageResource(R.drawable.forkert6);
            galgeLogik.erSpilletTabt();
            Intent tabt = new Intent(this, Tabt.class);
            startActivity(tabt);
        }
        if (galgeLogik.erSpilletVundet()) {
            galgeLogik.erSpilletVundet();
            Intent vundet = new Intent(this, Vundet.class);
            startActivity(vundet);
        }


    }

}