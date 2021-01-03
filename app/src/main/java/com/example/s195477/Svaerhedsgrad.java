package com.example.s195477;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.s195477.Data_layer.Data;

public class Svaerhedsgrad extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private static final String[] svaerhed = {"hard", "medium", "easy"};

    Data data = new Data();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svaerhedsgrad);

        spinner=(Spinner)findViewById(R.id.dropdown);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Svaerhedsgrad.this, android.R.layout.simple_spinner_item, svaerhed);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 1:
                try {
                    data.hentOrdFraRegneark("3");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    data.hentOrdFraRegneark("2");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    data.hentOrdFraRegneark("1");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}