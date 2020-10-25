package com.example.rigtiggalgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Spillet extends AppCompatActivity {

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
    }

    @Override
    public void onClick(){

    }

    public void spil(){
        if (galgeLogik.getAntalForkerteBogstaver()==1)
            imgview.setImageResource(R.drawable.forkert1);
        else if (galgeLogik.getAntalForkerteBogstaver()==2)
            imgview.setImageResource(R.drawable.forkert2);
        else if (galgeLogik.getAntalForkerteBogstaver()==3)
            imgview.setImageResource(R.drawable.forkert3);
        else if (galgeLogik.getAntalForkerteBogstaver()==4)
            imgview.setImageResource(R.drawable.forkert4);
        else if (galgeLogik.getAntalForkerteBogstaver()==5)
            imgview.setImageResource(R.drawable.forkert5);
        else if (galgeLogik.getAntalForkerteBogstaver()==6){
            imgview.setImageResource(R.drawable.forkert6);
            galgeLogik.erSpilletTabt();
        }
        if (galgeLogik.erSpilletVundet()){

        }


    }
}