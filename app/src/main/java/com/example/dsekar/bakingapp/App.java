package com.example.dsekar.bakingapp;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

public class App extends Application {

    static App context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = (App) getApplicationContext();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    public static App getContext() {
        return context;
    }
}


