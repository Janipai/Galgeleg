package com.example.s195477;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class SpillerListAdapter extends ArrayAdapter<Spiller> {

    TextView spillerPosition, spillerNavn, spillerScore;

    private Activity context;
    private ArrayList<Spiller> spillerArrayList;

    public SpillerListAdapter(@NonNull Activity context, @NonNull ArrayList<Spiller> spillerArrayList) {
        super(context, R.layout.spiller_list_item, spillerArrayList);
        this.context = context;
        this.spillerArrayList = spillerArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(R.layout.spiller_list_item, null, false);

        TextView textViewPosition = (TextView) convertView.findViewById(R.id.placering);
        TextView textViewName = (TextView) convertView.findViewById(R.id.navn);
        TextView textViewScore = (TextView) convertView.findViewById(R.id.score);

        Spiller spiller = spillerArrayList.get(position);

        textViewName.setText(spiller.getNavn());
        textViewScore.setText("" + spiller.getScore());
        textViewPosition.setText(position + 1 + "");

        return convertView;
    }
}
