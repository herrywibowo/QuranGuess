package com.herry.quran.guess.services;

import com.herry.quran.guess.data.ViewAyat;
import com.herry.quran.guess.data.ViewWord;

public interface GuessFace {
    ViewWord rollingWord(final boolean next);
    ViewAyat rollingAyat();
}
