package com.example.rigtiggalgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Hjaelp extends AppCompatActivity implements View.OnClickListener {

    Button regler, support;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hjaelp);

        regler = (Button) findViewById(R.id.regler);
        regler.setOnClickListener(this);

        support = (Button) findViewById(R.id.support);
        support.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.regler){
            //fragment
        }
        else if (v.getId()==R.id.regler){
            //fragment
        }

    }
}