package com.example.rigtiggalgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;

public class Highscore extends AppCompatActivity implements View.OnClickListener {

    SpillerListAdapter spillerAdapter;
    ListView listView;
    Gson gson = new Gson();
    ArrayList<Spiller> spillerListe = new ArrayList<>();
    ArrayList<String> highscore = new ArrayList<String>();
    Button tilbage, spilFraHighscore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore);
        tilbage = (Button) findViewById(R.id.tilbage);
        tilbage.setOnClickListener(this);
        spilFraHighscore = (Button) findViewById(R.id.spilFraHighscore);
        spilFraHighscore.setOnClickListener(this);

        SharedPreferences prefs = getSharedPreferences("Highscore", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        listView = (ListView) findViewById(R.id.highscoreListView);
        spillerAdapter = new SpillerListAdapter(this, spillerListe);
        listView.setAdapter(spillerAdapter);


        if (prefs.getStringSet("Highscores", null) != null) {
            Set<String> temp = prefs.getStringSet("Highscores", null);
            highscore = new ArrayList<String>(temp);
            for (String s : highscore) {
                Spiller spiller = gson.fromJson(s, Spiller.class);
                spillerListe.add(spiller);
            }
        }
        if (gson.fromJson(getIntent().getStringExtra("Spiller"), Spiller.class) != null) {
            Spiller spiller = gson.fromJson(getIntent().getStringExtra("Spiller"), Spiller.class);
            spillerListe.add(spiller);
            sortSpiller(spillerListe);

            for (Spiller s : spillerListe) {
                String hspiller = gson.toJson(s);
                highscore.add(hspiller);
            }

            Set<String> set = new HashSet<String>();
            set.addAll(highscore);
            editor.putStringSet("Highscores", set);
            editor.commit();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tilbage) {
            //explicit intent
            Intent hovedMenu = new Intent(this, Hovedmenu.class);
            startActivity(hovedMenu);
        } else if (v.getId() == R.id.spilFraHighscore) {
            Intent spil = new Intent(this, Spil.class);
            startActivity(spil);
        }
    }
    public ArrayList<Spiller> sortSpiller (ArrayList<Spiller> spillerListe) {
        for (int i = spillerListe.size() - 1; i > 0; i--) {
            if (spillerListe.get(i).getScore() > spillerListe.get(i - 1).getScore()) {
                Spiller temp = new Spiller(spillerListe.get(i - 1).getNavn(), spillerListe.get(i - 1).getScore());

                spillerListe.get(i - 1).setNavn(spillerListe.get(i).getNavn());
                spillerListe.get(i - 1).setScore(spillerListe.get(i).getScore());

                spillerListe.get(i).setNavn(temp.getNavn());
                spillerListe.get(i).setScore(temp.getScore());

            }
        }
        return spillerListe;
    }
}