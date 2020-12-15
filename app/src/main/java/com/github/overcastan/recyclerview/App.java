package com.github.overcastan.recyclerview;

import android.app.Application;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DataRepository.initialize(this);
    }
}
