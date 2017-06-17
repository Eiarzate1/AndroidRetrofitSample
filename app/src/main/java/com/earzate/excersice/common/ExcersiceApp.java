package com.earzate.excersice.common;

import android.app.Application;

/**
 * Created by earzate on 6/17/17.
 */

public class ExcersiceApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppContext.getInstance().setMock(false);
    }
}
