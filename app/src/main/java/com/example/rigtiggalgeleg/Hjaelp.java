package com.example.rigtiggalgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class Hjaelp extends AppCompatActivity {

    Button regler, support;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hjaelp);

        regler = (Button) findViewById(R.id.regler);
        regler.setOnClickListener(this);
    }
}