package com.example.s195477;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Hjaelp extends AppCompatActivity implements View.OnClickListener {

    Button regler, support;
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hjaelp);

        regler = (Button) findViewById(R.id.regler);
        regler.setOnClickListener(this);

        support = (Button) findViewById(R.id.support);
        support.setOnClickListener(this);

        info = (TextView) findViewById(R.id.info);
        info.setText("");
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.regler){
            info.setText("point systemet virker at hvis man gætter et bogstav rigtigt," +
                    " får man 5 poin og hvis man gætter et bogstav forkert får man -2 point");
        }
        else if (v.getId()==R.id.support){
            info.setText("Denne app er lavet af Shania Hau, s195477" +
                    "Derfor hvis der er nogle problemer bedes der henvendes til mailen: s195477@student.dtu.dk");
        }

    }
}