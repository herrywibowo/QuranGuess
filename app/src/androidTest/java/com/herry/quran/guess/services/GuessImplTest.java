package com.herry.quran.guess.services;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.herry.quran.guess.dao.DatabaseHelper;
import com.herry.quran.guess.dao.QuranDao;
import com.herry.quran.guess.dao.QuranFace;
import com.herry.quran.guess.data.ViewWord;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.sql.SQLException;

@RunWith(AndroidJUnit4.class)
public class GuessImplTest {

    DatabaseHelper helper = null;
    QuranFace dao = null;
    GuessFace guess = null;

    @Before
    public void init() throws IOException, SQLException {
        helper = new DatabaseHelper(InstrumentationRegistry.getTargetContext());
        helper.createDataBase();
        helper.openDataBase();
        dao = new QuranDao(helper.getWritableDatabase());
        guess = new GuessImpl(dao);
    }

    @Test
    public void rollingWord(){
        ViewWord viewWord = guess.rollingWord(false);
        Log.d("{}",viewWord.toString());
        viewWord = guess.rollingWord(true);
        Log.d("{}",viewWord.toString());
        viewWord = guess.rollingWord(false);
        Log.d("{}",viewWord.toString());
        viewWord = guess.rollingWord(true);
        Log.d("{}",viewWord.toString());
        viewWord = guess.rollingWord(false);
        Log.d("{}",viewWord.toString());
    }

    @Test
    public void after(){
        helper.close();
    }

}