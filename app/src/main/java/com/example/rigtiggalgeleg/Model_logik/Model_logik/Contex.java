package com.example.rigtiggalgeleg.Model_logik.Model_logik;

import android.widget.TextView;

import java.util.ArrayList;

public class Contex {
    private States states;
    private static Contex ctx = new Contex();

    /** AHT afprøvning er muligeOrd synlig på pakkeniveau */
    ArrayList<String> muligeOrd = new ArrayList<String>();
    protected String ordet;
    protected ArrayList<String> brugteBogstaver = new ArrayList<String>();
    protected String synligtOrd;
    protected int antalForkerteBogstaver;
    protected boolean sidsteBogstavVarKorrekt;
    protected boolean spilletErVundet;
    protected boolean spilletErTabt;

    //ny variable score
    private int score;
    TextView word;

    public ArrayList<String> getBrugteBogstaver() {
        return brugteBogstaver;
    }
    public String getSynligtOrd() {
        return synligtOrd;
    }
    public String getOrdet() {
        return ordet;
    }
    public int getAntalForkerteBogstaver() {
        return antalForkerteBogstaver;
    }
    public boolean erSidsteBogstavKorrekt() {
        return sidsteBogstavVarKorrekt;
    }
    public boolean erSpilletVundet() {
        return spilletErVundet;
    }
    public boolean erSpilletTabt() {
        return spilletErTabt;
    }
    public boolean erSpilletSlut() {
        return spilletErTabt || spilletErVundet;
    }

    //getter og setter for score
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public static Contex getInstance(){
        return ctx;
    }

    private Contex(){
        states  = new NotPlayingState();

        muligeOrd.add("bil");
        muligeOrd.add("computer");
        muligeOrd.add("programmering");
        muligeOrd.add("motorvej");
        muligeOrd.add("busrute");
        muligeOrd.add("gangsti");
        muligeOrd.add("skovsnegl");
        muligeOrd.add("solsort");
        muligeOrd.add("tyve");
    }

    public States getStates() {
        return states;
    }

    public void setStates(States states) {
        this.states = states;
    }

    public void opdaterSynligtOrd(Contex ctx) {
        ctx.synligtOrd = "";
        ctx.spilletErVundet = true;
        for (int n = 0; n < ctx.ordet.length(); n++) {
            String bogstav = ctx.ordet.substring(n, n + 1);
            if (ctx.brugteBogstaver.contains(bogstav)) {
                ctx.synligtOrd = ctx.synligtOrd + bogstav;
            } else {
                ctx.synligtOrd = ctx.synligtOrd + "*";
                ctx.spilletErVundet = false;
            }
        }
    }

    public void changeState(States state){
        this.states = state;
    }

    public void logStatus() {
        System.out.println("---------- ");
        System.out.println("- ordet (skult) = " + ordet);
        System.out.println("- synligtOrd = " + synligtOrd);
        System.out.println("- forkerteBogstaver = " + antalForkerteBogstaver);
        System.out.println("- brugeBogstaver = " + brugteBogstaver);
        if (spilletErTabt) System.out.println("- SPILLET ER TABT");
        if (spilletErVundet) System.out.println("- SPILLET ER VUNDET");
        System.out.println("---------- ");
    }

    public void startNytSpil(){
        states.startNytSpil(this);
    }
    public void gætBogstav(String bogstav){
        states.gætBogstav(this, bogstav);
    }

}
