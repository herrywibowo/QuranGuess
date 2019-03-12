package com.herry.quran.guess.data;

public class Word {
    private int id;
    private int surahId;
    private int ayatId;
    private String kata;
    private String arti;

    public Word(){}

    public Word(int id, String kata, String arti) {
        this.id = id;
        this.kata = kata;
        this.arti = arti;
    }

    public Word(int id, int surahId, int ayatId, String kata, String arti) {
        this.id = id;
        this.surahId = surahId;
        this.ayatId = ayatId;
        this.kata = kata;
        this.arti = arti;
    }

    public int getAyatId() {
        return ayatId;
    }

    public void setAyatId(int ayatId) {
        this.ayatId = ayatId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKata() {
        return kata;
    }

    public void setKata(String kata) {
        this.kata = kata;
    }

    public String getArti() {
        return arti;
    }

    public void setArti(String arti) {
        this.arti = arti;
    }

    public int getSurahId() {
        return surahId;
    }

    public void setSurahId(int surahId) {
        this.surahId = surahId;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", surahId=" + surahId +
                ", ayatId=" + ayatId +
                ", kata='" + kata + '\'' +
                ", arti='" + arti + '\'' +
                '}';
    }
}
