package com.example.rigtiggalgeleg.Model_logik.Model_logik;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class NotPlayingState extends Adapter {

    //nulstiller
    public void nulstil(Contex ctx) {
        ctx.brugteBogstaver.clear();
        ctx.antalForkerteBogstaver = 0;
        ctx.spilletErVundet = false;
        ctx.spilletErTabt = false;
    }

    public void startNytSpil(Contex ctx) {
        nulstil(ctx);
        if (ctx.muligeOrd.isEmpty()) throw new IllegalStateException("Listen over mulige ord er tom!");
        ctx.ordet = ctx.muligeOrd.get(new Random().nextInt(ctx.muligeOrd.size()));
        System.out.println("Nyt spil - det skjulte ord er: "+ctx.ordet);
        ctx.opdaterSynligtOrd(ctx);
        ctx.changeState(new PlayingState());
    }
}
