package com.herry.quran.guess.dao;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.sql.SQLException;

@RunWith(AndroidJUnit4.class)
public class WordFaceTest {

    DatabaseHelper helper = null;
    QuranFace dao = null;

    @Before
    public void init() throws IOException, SQLException {
        helper = new DatabaseHelper(InstrumentationRegistry.getTargetContext());
        helper.createDataBase();
        helper.openDataBase();
        dao = new QuranDao(helper.getWritableDatabase());
    }

    @Test
    public void getKataBenar() {
        System.out.println(dao.getKataBenar());
        dao.clearPosition();
        dao.updatePosition(1);
        System.out.println(dao.getKataBenar());
    }

    @Test
    public void getKata() {
        System.out.println(dao.getKata(100));
    }

    @After
    public void after(){
        helper.close();
    }
}