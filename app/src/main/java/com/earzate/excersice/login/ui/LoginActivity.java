package com.earzate.excersice.login.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.earzate.excersice.R;
import com.earzate.excersice.common.AppContext;
import com.earzate.excersice.login.model.LoginRequestModel;
import com.earzate.excersice.login.model.LoginResponseModel;
import com.earzate.excersice.rest.factory.UserServiceFactory;
import com.earzate.excersice.rest.service.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button button = (Button) findViewById(R.id.sign_in_button);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                performSignIn();
            }
        });
    }

    private void performSignIn(){
        AutoCompleteTextView username = (AutoCompleteTextView) findViewById(R.id.email);
        EditText password = (EditText) findViewById(R.id.password);

        LoginRequestModel requestModel = new LoginRequestModel();
        requestModel.setUsername(username.getText().toString().trim());
        requestModel.setPassword(password.getText().toString().trim());

        UserService userService = UserServiceFactory.getUserServiceInstance(this, "http://some.domain.com/", AppContext.getInstance().isMock());

        Call<LoginResponseModel> call = userService.authenticate(requestModel);
        call.enqueue(new Callback<LoginResponseModel>() {
            @Override
            public void onResponse(Call<LoginResponseModel> call, Response<LoginResponseModel> response) {
                LinearLayout linearLayout = (LinearLayout)findViewById(R.id.loginLayout);
                if(response.isSuccessful()){
                    Snackbar snackbar = Snackbar.make(linearLayout, response.body().getSessionId(), Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponseModel> call, Throwable t) {

            }
        });


    }


}

