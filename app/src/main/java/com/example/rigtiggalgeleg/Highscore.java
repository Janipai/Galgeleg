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

    SpillerListAdapter spillerAdapter;
    ListView listView;
    ArrayList<Spiller> spillerListe= new ArrayList<>();
    Gson gson = new Gson();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore);

        SharedPreferences prefs = getSharedPreferences("Highscore", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        listView = (ListView) findViewById(R.id.highscoreListView);

        Spiller spiller = gson.fromJson(getIntent().getStringExtra("Spiller"), Spiller.class);
        spillerListe.add(spiller);

        spillerAdapter = new SpillerListAdapter(this, spillerListe);
        listView.setAdapter(spillerAdapter);
    }

    @Override
    public void onClick(View v) {
        Intent spil = new Intent(this, Spil.class);
        startActivity(spil);
    }
}