package com.example.aungko.suhtar;

import android.app.Application;

import com.example.aungko.suhtar.helper.FontEmbedder;
import com.example.aungko.suhtar.helper.Moulder;
import com.example.aungko.suhtar.helper.TypefaceManager;

import me.myatminsoe.mdetect.MDetect;

public class MainApplication extends Application {

    public static TypefaceManager typefaceManager;

    @Override
    public void onCreate() {
        super.onCreate();
        MDetect.INSTANCE.init(this);

        typefaceManager = new TypefaceManager(getAssets());

        if (MDetect.INSTANCE.isUnicode()){
            FontEmbedder.init(typefaceManager.getShitUnicode());
            Moulder.init(true);
        }else {
            FontEmbedder.init(typefaceManager.getShitZawgyi());
            Moulder.init(false);
        }
    }

}
