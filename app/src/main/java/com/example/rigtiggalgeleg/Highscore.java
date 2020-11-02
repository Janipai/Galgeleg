package com.example.rigtiggalgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;

public class Highscore extends AppCompatActivity implements View.OnClickListener {

    TextView highscoreName, highscoreScore, position;

    ArrayList<String> highscore = new ArrayList<String>();
    ArrayList<Spiller> spillerArrayListay = new ArrayList<Spiller>();
    ListView listView = (ListView) findViewById(R.id.highscore);
    Gson gson = new Gson();
    Spiller burhan = new Spiller("ga", 2);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore);

        SpillerListAdapter adapter = new ArrayAdapter()
    }

    @Override
    public void onClick(View v) {
        Intent spil = new Intent(this, Spil.class);
        startActivity(spil);
    }
}