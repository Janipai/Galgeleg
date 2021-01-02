package com.example.s195477;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Multiplayer extends AppCompatActivity implements View.OnClickListener {

    Button selvValgtOrd, fraOrdListe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer);

        selvValgtOrd = (Button) findViewById(R.id.selvValgtOrd);
        fraOrdListe = (Button) findViewById(R.id.fraOrdliste);

        selvValgtOrd.setOnClickListener(this);
        fraOrdListe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.selvValgtOrd) {
            Intent selvValgtOrd = new Intent(this, SelvValgtOrd.class);
            startActivity(selvValgtOrd);
        } else if (v.getId() == R.id.fraOrdliste) {
            Intent fraOrdliste = new Intent(this, OrdListe.class);
            startActivity(fraOrdliste);
        }
    }
}