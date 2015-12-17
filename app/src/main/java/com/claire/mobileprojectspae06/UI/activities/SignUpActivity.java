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
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;


/**
 * Created by Claire on 16/12/2015.
 */
public class SignUpActivity extends AppCompatActivity {

    private EditText emailField;
    private EditText pwdField;
    private Button validateBtn;
    private Button mAlreadyUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        emailField = (EditText) findViewById(R.id.email_address);
        pwdField = (EditText) findViewById(R.id.password);

        validateBtn = (Button) findViewById(R.id.btn_login_register);

        validateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailField.getText().toString();
                String pwd = pwdField.getText().toString();

                email = email.trim();
                pwd = pwd.trim();

                if (email.isEmpty() || pwd.isEmpty()) {
                    Toast.makeText(MyApp.getContext(), "Your email or password is empty", Toast.LENGTH_SHORT).show();
                } else {

                    final ParseUser newUser = new ParseUser();
                    newUser.setEmail(email);
                    newUser.setPassword(pwd);
                    newUser.signUpInBackground(new SignUpCallback() {
                        public void done(ParseException e) {
                            if (e == null) {
                                // Success!
                                Intent intent = new Intent(MyApp.getInstance(), UserProfileActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(MyApp.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }

                    });
                }
            }
        });

        mAlreadyUser = (Button) findViewById(R.id.already_user);
        mAlreadyUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyApp.getInstance(), MainActivity.class);
                startActivity(intent);
                finish();
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
        return id == R.id.action_settings || onOptionsItemSelected(item);
    }
}
