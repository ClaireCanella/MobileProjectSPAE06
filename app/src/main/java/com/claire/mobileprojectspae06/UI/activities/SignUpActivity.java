package com.claire.mobileprojectspae06.UI.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import com.claire.mobileprojectspae06.MyApp;
import com.claire.mobileprojectspae06.R;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.location.places.Places;



/**
 * Created by Claire on 16/12/2015.
 */
public class SignUpActivity extends AppCompatActivity {

    private EditText emailField;
    private EditText pwdField;
    private EditText usernameField;
    private EditText locationField;
    private Switch switch1Field;
    private ImageButton btnPhoto;
    private Button validateBtn;
    private Button mAlreadyUser;
    private GoogleApiClient mGoogleApiClient;


    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        


        emailField = (EditText) findViewById(R.id.email_address);
        pwdField = (EditText) findViewById(R.id.password);
        usernameField = (EditText) findViewById(R.id.username);
        locationField = (EditText) findViewById(R.id.location);
        switch1Field = (Switch) findViewById(R.id.switch1);
        btnPhoto = (ImageButton) findViewById(R.id.btn_photo);
        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });


        validateBtn = (Button) findViewById(R.id.btn_login_register);

        validateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailField.getText().toString();
                String pwd = pwdField.getText().toString();
                String username = usernameField.getText().toString();
                String location = locationField.getText().toString();
                Switch switchAnimal = switch1Field;

                email = email.trim();//évite d'avoir des espaces à l'auto-complete
                pwd = pwd.trim();
                username = username.trim();
                location = location.trim();


                /*
                if (email.isEmpty() || pwd.isEmpty() || username.isEmpty() || location.isEmpty()) {
                    Toast.makeText(MyApp.getContext(), "A field is empty", Toast.LENGTH_SHORT).show();
                } else {

                    ParseUser newUser = new ParseUser();
                    newUser.setEmail(email);
                    newUser.setPassword(pwd);
                    newUser.setUsername(username);
                    newUser.setLocation(location);
                    newUser.setAnimal(switchAnimal);

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
                }*/
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
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
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

    //Lorsqu'on a pris une photo
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            //mImageView.setImageBitmap(imageBitmap);
        }
    }

    @Override
    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }
}
