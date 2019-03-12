package com.herry.quran.guess.dao;

import com.herry.quran.guess.data.Ayat;
import com.herry.quran.guess.data.Word;

public interface QuranFace {
    Word getKataBenar();
    Word getKata(int id);
    void clearPosition();
    void updatePosition(int id);
    String getSurah(int surahId);
    Ayat getAyat(int surah, int ayat);
}
