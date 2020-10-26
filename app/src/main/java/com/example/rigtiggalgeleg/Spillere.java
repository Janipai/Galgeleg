package com.example.rigtiggalgeleg;

public class Spillere {
    private String navn;
    private int score;

    public Spillere(String navn, int score) {
        this.navn = navn;
        this.score = score;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Spillere (Spillere s){
        Spillere spillere = new Spillere(s.navn,score);
    }
}
