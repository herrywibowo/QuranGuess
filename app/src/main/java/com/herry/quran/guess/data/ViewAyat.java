package com.herry.quran.guess.data;

public class ViewAyat {
    private String surah;
    private int ayat;
    private String isiAyat;
    private String artiAyat;

    public ViewAyat(String surah, int ayat, String isiAyat, String artiAyat) {
        this.surah = surah;
        this.ayat = ayat;
        this.isiAyat = isiAyat;
        this.artiAyat = artiAyat;
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

    public String getIsiAyat() {
        return isiAyat;
    }

    public void setIsiAyat(String isiAyat) {
        this.isiAyat = isiAyat;
    }

    public String getArtiAyat() {
        return artiAyat;
    }

    public void setArtiAyat(String artiAyat) {
        this.artiAyat = artiAyat;
    }

    @Override
    public String toString() {
        return "ViewAyat{" +
                "surah='" + surah + '\'' +
                ", ayat=" + ayat +
                ", isiAyat='" + isiAyat + '\'' +
                ", artiAyat='" + artiAyat + '\'' +
                '}';
    }
}
