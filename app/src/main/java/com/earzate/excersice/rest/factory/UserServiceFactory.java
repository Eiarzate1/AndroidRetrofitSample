package com.earzate.excersice.rest.factory;

import android.content.Context;

import com.earzate.excersice.rest.RestApi;
import com.earzate.excersice.rest.service.UserService;

/**
 * Created by earzate on 6/17/17.
 */

public class UserServiceFactory {

    private static UserService userServiceInstance = null;

    public static UserService getUserServiceInstance(Context context, String url, boolean mock){
        if(userServiceInstance == null){
            userServiceInstance = RestApi.getInstance(context, url, mock).create(UserService.class);
        }
        return  userServiceInstance;
    }


}
