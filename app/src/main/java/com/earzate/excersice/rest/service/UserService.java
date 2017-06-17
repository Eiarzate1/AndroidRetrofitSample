package com.earzate.excersice.rest.service;

import com.earzate.excersice.login.model.LoginRequestModel;
import com.earzate.excersice.login.model.LoginResponseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by earzate on 6/17/17.
 */

public interface UserService {

    @POST("/authenticate")
    Call<LoginResponseModel> authenticate(@Body LoginRequestModel loginRequestModel);

}
