package com.earzate.excersice.login.model;

import com.earzate.excersice.common.model.ResponseModel;

/**
 * Created by earzate on 6/17/17.
 */

public class LoginResponseModel extends ResponseModel {

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    private String sessionId;


}
