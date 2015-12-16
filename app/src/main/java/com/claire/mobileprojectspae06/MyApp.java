package com.claire.mobileprojectspae06;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Claire on 16/12/2015.
 */
public class MyApp extends Application {

    private static MyApp sharedInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        MyApp.sharedInstance = this;

        // [Optional] Power your app with Local Datastore. For more info, go to
        // https://parse.com/docs/android/guide#local-datastore
        Parse.enableLocalDatastore(this);
        Parse.initialize(this);
    }

    public static MyApp getInstance() {
        return sharedInstance;
    }

}
