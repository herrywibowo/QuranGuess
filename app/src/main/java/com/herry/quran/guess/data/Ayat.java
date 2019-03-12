package com.herry.quran.guess.data;

public class Ayat {
    private String isiAyat;
    private String artiAyat;

    public Ayat(String isiAyat, String artiAyat) {
        this.isiAyat = isiAyat;
        this.artiAyat = artiAyat;
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
        return "Ayat{" +
                "isiAyat='" + isiAyat + '\'' +
                ", artiAyat='" + artiAyat + '\'' +
                '}';
    }
}
