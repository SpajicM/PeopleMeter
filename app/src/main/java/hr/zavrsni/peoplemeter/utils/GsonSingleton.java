package hr.zavrsni.peoplemeter.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonSingleton {
    private static GsonSingleton sInstance;
    private Gson mGson;

    private GsonSingleton() {
        mGson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
    }

    public static GsonSingleton getInstance() {
        if (sInstance == null) {
            sInstance = new GsonSingleton();
        }
        return sInstance;
    }

    public Gson getGson() {
        return mGson;
    }
}