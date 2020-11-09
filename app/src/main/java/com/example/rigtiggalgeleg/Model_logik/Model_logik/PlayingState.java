package com.example.rigtiggalgeleg.Model_logik.Model_logik;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class PlayingState extends Adapter {

    public void gætBogstav(Contex ctx, String bogstav) {

        System.out.println("Der gættes på bogstavet: " + bogstav);
        if (ctx.brugteBogstaver.contains(bogstav)) return;
        if (ctx.spilletErVundet || ctx.spilletErTabt) return;

        ctx.brugteBogstaver.add(bogstav);

        if (ctx.ordet.contains(bogstav)) {
            ctx.sidsteBogstavVarKorrekt = true;
            System.out.println("Bogstavet var korrekt: " + bogstav);
        } else {
            // Vi gættede på et bogstav der ikke var i ordet.
            ctx.sidsteBogstavVarKorrekt = false;
            System.out.println("Bogstavet var IKKE korrekt: " + bogstav);
            ctx.antalForkerteBogstaver = ctx.antalForkerteBogstaver + 1;
            if (ctx.antalForkerteBogstaver > 6) {
                ctx.spilletErTabt = true;
                ctx.changeState(new NotPlayingState());
            }
        }
        ctx.opdaterSynligtOrd(ctx);
    }

}
