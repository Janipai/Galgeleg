package com.example.s195477;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Multiplayer extends Fragment implements View.OnClickListener {


    Button selvValgtOrd, fraOrdListe;

    public Multiplayer() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_multiplayer, container, false);

        selvValgtOrd = (Button) view.findViewById(R.id.selvValgtOrd);
        fraOrdListe = (Button) view.findViewById(R.id.fraOrdliste);

        selvValgtOrd.setOnClickListener(this);
        fraOrdListe.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.selvValgtOrd) {
            // Create new fragment and transaction
            Fragment selvValgt = new SelvValgtOrd();
            FragmentTransaction transaction =  ((Hovedmenu) getActivity()).getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack if needed
            transaction.replace(R.id.frame_selvValgtord, selvValgt);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        } else if (v.getId() == R.id.fraOrdliste) {
            // Create new fragment and transaction
            Fragment fraOrdliste = new SelvValgtOrd();
            FragmentTransaction transaction = ((Hovedmenu) getActivity()).getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack if needed
            transaction.replace(R.id.frame_ordListe, fraOrdliste);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    }

}