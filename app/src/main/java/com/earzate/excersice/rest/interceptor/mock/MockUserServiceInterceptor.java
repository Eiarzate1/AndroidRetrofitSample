package com.earzate.excersice.rest.interceptor.mock;

import com.earzate.excersice.login.model.LoginRequestModel;
import com.earzate.excersice.login.model.LoginResponseModel;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

/**
 * Created by earzate on 6/17/17.
 */

public class MockUserServiceInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Gson gson = new Gson();

        HttpUrl url = chain.request().url();
        Request request = chain.request();
        Response response = null;
        LoginRequestModel loginRequestModel = gson.fromJson(bodyToString(request.body()), LoginRequestModel.class);

        if("/authenticate".contains(url.uri().getPath()))
        if(loginRequestModel.getUsername().equals("emarzate") && loginRequestModel.getPassword().equals("password")){
            LoginResponseModel loginResponseModel = new LoginResponseModel();
            loginResponseModel.setSessionId("ABBC-2929-KKSK-CCCC");
            loginResponseModel.setCode("200");
            String responseString = gson.toJson(loginResponseModel);
            ResponseBody responseBody = ResponseBody.create(MediaType.parse("application/json"), responseString.getBytes());
            response = new Response.Builder()
                    .code(200)
                    .message("SUCCESS")
                    .request(chain.request())
                    .protocol(Protocol.HTTP_1_0)
                    .body(responseBody)
                    .addHeader("content-type", "application/json")
                    .build();
        } else{
            response = chain.proceed(request);
        }

        return response;

    }

    private String bodyToString(final RequestBody request) {
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if (copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }

}
