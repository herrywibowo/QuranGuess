package com.herry.quran.guess.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.herry.quran.guess.data.Ayat;
import com.herry.quran.guess.data.Word;

public class QuranDao implements QuranFace {

    private final SQLiteDatabase db;
    public QuranDao(SQLiteDatabase db) {
        this.db = db;
    }

    public Word getKataBenar(){
        Cursor cursor = db.rawQuery("SELECT _id,surah_id,verse_id,words_ar,translate_indo FROM  bywords where position=1", null);
        if(cursor.moveToNext()) {
            return new Word(cursor.getInt(0), cursor.getInt(1),
                    cursor.getInt(2),cursor.getString(3),
                    cursor.getString(4));
        }else{
            return null;
        }
    }

    public Word getKata(int id){
        Cursor cursor = db.rawQuery("SELECT _id,surah_id,verse_id,words_ar,translate_indo FROM  bywords where _id="+id, null);
        if(cursor.moveToNext()) {
            return new Word(cursor.getInt(0), cursor.getInt(1),
                    cursor.getInt(2),cursor.getString(3),
                    cursor.getString(4));
        }else{
            return null;
        }
    }

    @Override
    public void clearPosition() {
        db.execSQL("update bywords set position=0 where position=1");
    }

    @Override
    public void updatePosition(int id) {
        db.execSQL("update bywords set position=1 where _id="+id);
    }

    @Override
    public String getSurah(int surahId) {
        Cursor cursor = db.rawQuery("select name_english from surah_name where surah_no="+surahId, null);
        if(cursor.moveToNext()) {
            return cursor.getString(0);
        }else{
            return null;
        }
    }

    @Override
    public Ayat getAyat(int surah, int ayat) {
        Cursor cursor = db.rawQuery("select arabic,indo from quran where surah_id="+surah+" and verse_id="+ayat, null);
        if(cursor.moveToNext()) {
            return new Ayat(cursor.getString(0),cursor.getString(1));
        }else{
            return null;
        }
    }
}
