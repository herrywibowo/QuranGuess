package com.herry.quran.guess.data;

public class ViewWord {
    String surah;
    int ayat;
    String kata;
    String artiBenar;
    String artiA;
    String artiB;
    int score;

    public String getKata() {
        return kata;
    }

    public void setKata(String kata) {
        this.kata = kata;
    }

    public String getArtiBenar() {
        return artiBenar;
    }

    public void setArtiBenar(String artiBenar) {
        this.artiBenar = artiBenar;
    }

    public String getArtiA() {
        return artiA;
    }

    public void setArtiA(String artiA) {
        this.artiA = artiA;
    }

    public String getArtiB() {
        return artiB;
    }

    public void setArtiB(String artiB) {
        this.artiB = artiB;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isCorrect(String ans){
        return this.artiBenar.equals(ans);
    }

    public String getSurah() {
        return surah;
    }

    public void setSurah(String surah) {
        this.surah = surah;
    }


    public int getAyat() {
        return ayat;
    }

    public void setAyat(int ayat) {
        this.ayat = ayat;
    }

    @Override
    public String toString() {
        return "ViewWord{" +
                "surah='" + surah + '\'' +
                ", kata='" + kata + '\'' +
                ", artiBenar='" + artiBenar + '\'' +
                ", artiA='" + artiA + '\'' +
                ", artiB='" + artiB + '\'' +
                ", score=" + score +
                '}';
    }
}
