package com.claire.mobileprojectspae06.UI.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.claire.mobileprojectspae06.MyApp;
import com.claire.mobileprojectspae06.R;
import com.claire.mobileprojectspae06.UI.adapters.AnimalsAdapter;

import com.claire.mobileprojectspae06.UserProfile;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.parse.LogInCallback;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    protected EditText mEmailLogin_EditText;
    protected EditText mPwdLogin_EditText;
    protected Button mBtnNewUser;
    protected Button mBtnLogin;
    private ImageView mImageView;


    private AnimalsAdapter animalsAdapter;
    ArrayList<String> animalListView = new ArrayList<String>();


    static final int REQUEST_IMAGE_CAPTURE = 1;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();*/

        mEmailLogin_EditText = (EditText) findViewById(R.id.email_address);
        mPwdLogin_EditText = (EditText) findViewById(R.id.password);
        mBtnNewUser = (Button) findViewById(R.id.btn_new_user);
        mBtnLogin = (Button) findViewById(R.id.btn_login);


        mBtnNewUser = (Button) findViewById(R.id.btn_new_user);
        mBtnNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyApp.getInstance(), SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmailLogin_EditText.getText().toString();
                String password = mPwdLogin_EditText.getText().toString();

                email = email.trim();
                password = password.trim();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MyApp.getContext(), "Email or Password is empy", Toast.LENGTH_SHORT).show();
                } else {
                    System.out.println(email);
                    System.out.println(password);
                    if (email.equals("admin@admin.fr") && password.equals("admin")) {
                        Toast.makeText(MyApp.getContext(), "Hello admin", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(MyApp.getInstance(), UserProfileActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    ;


                    /*ParseUser.logInInBackground(email, password, new LogInCallback() {
                        @Override
                        public void done(ParseUser user, com.parse.ParseException e) {
                            System.out.println(e.getMessage());
                            System.out.println(e.getCode());
                            if (e == null) {
                                // Success!
                                Toast.makeText(MyApp.getContext(), "Success !!!!.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MyApp.getInstance(), UserProfileActivity.class);
                                startActivity(intent);
                            } else {
                                // Fail
                                Toast.makeText(MyApp.getContext(), "Fail. No user.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });*/

                }
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //Lorsqu'on a pris une photo
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);
        }
    }



}
