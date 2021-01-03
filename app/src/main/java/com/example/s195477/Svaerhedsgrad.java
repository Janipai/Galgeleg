package com.example.s195477;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.s195477.Data_layer.Data;
import com.example.s195477.Model_logik.Model_logik.Contex;
import com.example.s195477.Model_logik.Model_logik.NotPlayingState;
import com.google.gson.Gson;

public class Svaerhedsgrad extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private Spinner spinner;
    private static final String[] svaerhed = {"hard", "medium", "easy"};

    Contex ctx = Contex.getInstance();
    Button confirm;
    EditText playersname;
    Data data = new Data();
    Spiller spiller;
    TextView errormesseng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svaerhedsgrad);

        playersname = findViewById(R.id.playersname);

        errormesseng = findViewById(R.id.errormesseng);
        errormesseng.setText("");

        confirm = findViewById(R.id.confirmsvaerhed);
        confirm.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        String playername = playersname.getText().toString();
        int score = 0;

        if (v.getId()==R.id.confirmsvaerhed && playername.equals("")){

            spiller = new Spiller(playersname.getText().toString(), score);

            //explicit intent
            Intent spil = new Intent(this, Spil.class);
            startActivity(spil);
            ctx.changeState(new NotPlayingState());
        }else{
            //playername is not typed
            errormesseng.setText("Du mangler at skrive spiller navn");
        }
    }
}