package com.example.rigtiggalgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Spillet extends AppCompatActivity implements View.OnClickListener {

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

        guess = (Button) findViewById(R.id.gaet);
        guess.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.gaet){

        }

        EditText ed = (EditText) findViewById(R.id.inputField);
        ed.getText();
    }

    public void spil() {
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
        }
        if (galgeLogik.erSpilletVundet()) {

        }


    }

}