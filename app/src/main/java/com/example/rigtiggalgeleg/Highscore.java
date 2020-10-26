package com.example.rigtiggalgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Highscore extends AppCompatActivity {

    ArrayList<Spillere> spillers = new ArrayList<Spillere>();
    ArrayList<String> highscore = new ArrayList<String>();
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore);
    }

    @Override
    public View getView ( int position, View convertView, ViewGroup container){
        return ;
    }
}