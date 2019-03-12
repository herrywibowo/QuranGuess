package com.herry.quran.guess.services;

import com.herry.quran.guess.dao.QuranFace;
import com.herry.quran.guess.data.Ayat;
import com.herry.quran.guess.data.ViewAyat;
import com.herry.quran.guess.data.ViewWord;
import com.herry.quran.guess.data.Word;

import java.util.Random;

public class GuessImpl implements GuessFace {

    private QuranFace wordDao;
    private static final int MAX = 10;
    private static final Random RANDOMTOOL = new Random();

    public GuessImpl(QuranFace wordDao){
       this.wordDao = wordDao;
    }

    @Override
    public ViewWord rollingWord(final boolean next) {
        final ViewWord vWord = new ViewWord();
        if(next){
            final int nextId = wordDao.getKataBenar().getId()+1;
            wordDao.clearPosition();
            wordDao.updatePosition(nextId);
        }
        buildWord(vWord);
        return vWord;
    }

    @Override
    public ViewAyat rollingAyat() {
        if(isNextAyat()){
            return getViewAyat();
        }else {
            return null;
        }
    }

    private void buildWord(ViewWord vWord){
        final Word kataBenar = wordDao.getKataBenar();
        final int randomId = RANDOMTOOL.nextInt(MAX)+kataBenar.getId()+1;
        final Word kataRandom = wordDao.getKata(randomId);
        vWord.setKata(kataBenar.getKata());
        vWord.setArtiBenar(kataBenar.getArti());

        final boolean randomState = RANDOMTOOL.nextBoolean();
        vWord.setArtiA(getKataTerRandom(randomState,kataBenar.getArti(), kataRandom.getArti()));
        vWord.setArtiB(getKataTerRandom(!randomState,kataBenar.getArti(), kataRandom.getArti()));
        vWord.setScore(kataBenar.getId());
        vWord.setSurah(wordDao.getSurah(kataBenar.getSurahId()));
        vWord.setAyat(kataBenar.getAyatId());
    }

    private String getKataTerRandom(final boolean randomState, final String a, final String b){
        String c = b;
        if(randomState){
            c = a;
        }
        return c;
    }

    private int getCurrentAyat(){
        return wordDao.getKataBenar().getAyatId();
    }

    private int getCurrentId(){
        return wordDao.getKataBenar().getId();
    }

    private int getNextAyat(){
        final Word word = wordDao.getKata(getCurrentId()+1);
        return word!=null?word.getAyatId():0;
    }

    private boolean isNextAyat(){
        int b = getNextAyat();
        int c = getCurrentAyat();
        return c != b && b>0;
    }

    private ViewAyat getViewAyat(){
        final Word wordNeeded = wordDao.getKata(getCurrentId()-1);
        final String surah = wordDao.getSurah(wordNeeded.getSurahId());
        final Ayat ayat = wordDao.getAyat(wordNeeded.getSurahId(), wordNeeded.getAyatId());
       return new ViewAyat(surah,wordNeeded.getAyatId(), ayat.getIsiAyat(), ayat.getArtiAyat());
    }
}
