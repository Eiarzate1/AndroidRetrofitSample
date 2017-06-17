package com.earzate.excersice.rest;

import android.content.Context;

import com.earzate.excersice.rest.interceptor.mock.MockUserServiceInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by earzate on 6/17/17.
 */

public class RestApi {

    private static Retrofit retrofitInstance = null;

    public static Retrofit getInstance(Context context, String url, boolean mock){

        if(retrofitInstance == null){
            final OkHttpClient okHttpClient = getOkHttpClient(mock);

            retrofitInstance = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(url)
                    .client(okHttpClient)
                    .build();

        }

        return retrofitInstance;
    }

    private static OkHttpClient getOkHttpClient(boolean mock){
        OkHttpClient okHttpClient = null;
        if(mock){
            okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new MockUserServiceInterceptor())
                    .build();
        }else{
            okHttpClient = new OkHttpClient.Builder()
                    .build();
        }

        return  okHttpClient;
    }

}
