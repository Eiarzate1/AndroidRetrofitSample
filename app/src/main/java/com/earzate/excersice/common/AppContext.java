package com.earzate.excersice.common;

/**
 * Created by earzate on 6/17/17.
 */

public class AppContext {
    private static AppContext appContext = null;

    private boolean mock;

    public boolean isMock() {
        return mock;
    }

    public void setMock(boolean mock) {
        this.mock = mock;
    }

    public static AppContext getInstance(){
        if(appContext == null){
            appContext = new AppContext();
        }
        return  appContext;
    }

}
