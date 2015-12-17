package com.claire.mobileprojectspae06.UI.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.claire.mobileprojectspae06.MyApp;
import com.claire.mobileprojectspae06.R;

public class Signup extends AppCompatActivity implements View.OnClickListener {

    private Button mAlreadyUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAlreadyUser = (Button) findViewById(R.id.already_user);

    }

    @Override
    protected void onStart(){
        super.onStart();
        mAlreadyUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mAlreadyUser){
            Intent intent = new Intent(MyApp.getInstance(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
