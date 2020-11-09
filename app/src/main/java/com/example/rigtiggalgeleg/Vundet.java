package com.example.rigtiggalgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rigtiggalgeleg.Model_logik.Model_logik.Contex;
import com.example.rigtiggalgeleg.Model_logik.Model_logik.PlayingState;
import com.google.gson.Gson;

public class Vundet extends AppCompatActivity implements View.OnClickListener {

    Contex ctx = Contex.getInstance();
    Button spilIgen, highscore;
    EditText highscoreNavn;
    int score;
    Spiller spiller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vundet);

        score = getIntent().getIntExtra("Score", 0);

        TextView vundetTxtView = (TextView) findViewById(R.id.textView2);
        vundetTxtView.setText("Din score: " + score);

        spilIgen = (Button) findViewById(R.id.spilIgen2);
        spilIgen.setOnClickListener(this);

        highscore = (Button) findViewById(R.id.submit);
        highscore.setOnClickListener(this);

        highscoreNavn = (EditText) findViewById(R.id.navnTilHighscore);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.spilIgen2) {
            ctx.startNytSpil();
            Intent spil = new Intent(this, Spil.class);
            spil.putExtra("Score", score);
            startActivity(spil);
        } else if (v.getId() == R.id.submit) {
            Intent highscore = new Intent(this, Highscore.class);

            spiller = new Spiller(highscoreNavn.getText().toString(), score);
            Gson gson = new Gson();
            String spillerInfo = gson.toJson(spiller);
            highscore.putExtra("Spiller", spillerInfo);

            startActivity(highscore);
        }
    }
}