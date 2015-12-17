package com.claire.mobileprojectspae06.UI.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.claire.mobileprojectspae06.MyApp;
import com.claire.mobileprojectspae06.R;
import com.parse.LogInCallback;
import com.parse.ParseUser;

/**
 * Created by Claire on 16/12/2015.
 */
public class LoginActivity extends AppCompatActivity {

    protected EditText mEmailLogin_EditText;
    protected EditText mPwdLogin_EditText;
    protected Button mBtnValidateLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmailLogin_EditText = (EditText)findViewById(R.id.email_address);
        mPwdLogin_EditText = (EditText)findViewById(R.id.password);
        mBtnValidateLogin = (Button)findViewById(R.id.btn_login);

        mBtnValidateLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                String email = mEmailLogin_EditText.getText().toString();
                String password = mPwdLogin_EditText.getText().toString();

                email = email.trim();
                password = password.trim();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MyApp.getContext(), "Email or Password is empy", Toast.LENGTH_SHORT).show();
                } else {
                    System.out.println(mEmailLogin_EditText.getText());
                    ParseUser.logInInBackground(email, password, new LogInCallback() {
                        @Override
                        public void done(ParseUser user, com.parse.ParseException e) {
                            if (e == null) {
                                // Success!
                                Intent intent = new Intent(MyApp.getInstance(), MainActivity.class);
                                startActivity(intent);
                            } else {
                                // Fail
                                Toast.makeText(MyApp.getContext(), "Fail. No user.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }
}