package com.example.s195477;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SelvValgtOrd extends AppCompatActivity implements View.OnClickListener {

    EditText input;
    Button confirm;
    TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selv_valgt_ord);

        input = findViewById(R.id.inputSelvValgtOrd);

        confirm = findViewById(R.id.confirmButton);
        confirm.setOnClickListener(this);

        error = findViewById(R.id.txterror);
        error.setText("");
    }

    @Override
    public void onClick(View v) {
        String wordToGuess = input.getText().toString();

        if (v.getId() == R.id.confirmButton && wordToGuess.equals("")) {
            error.setText("Du har ikke valgt et ord din modstander skal gætte :'(");
        }else if (v.getId() == R.id.confirmButton) {
            Intent spil = new Intent(this, Spil.class);
            startActivity(spil);
        }
    }
}