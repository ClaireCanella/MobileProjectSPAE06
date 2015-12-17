package com.claire.mobileprojectspae06.UI.activities;

import android.content.Intent;
import android.graphics.Bitmap;
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

import com.parse.LogInCallback;
import com.parse.ParseUser;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    protected EditText mEmailLogin_EditText;
    protected EditText mPwdLogin_EditText;
    protected Button mBtnValidateLogin;
    protected Button mBtnNewUser;
    protected Button mBtnLogin;
    private ImageView mImageView;


    private AnimalsAdapter animalsAdapter;
    ArrayList<String> animalListView = new ArrayList<String>();


    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

       /*ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser == null) {
            Intent intent = new Intent(MyApp.getInstance(), LoginActivity.class);
            startActivity(intent);
        }*/

        mEmailLogin_EditText = (EditText)findViewById(R.id.email_address);
        mPwdLogin_EditText = (EditText)findViewById(R.id.password);
        mBtnValidateLogin = (Button)findViewById(R.id.btn_login);
        mBtnNewUser = (Button) findViewById(R.id.btn_new_user);
        mBtnLogin = (Button) findViewById(R.id.btn_login);


        //mImageView = (ImageView) findViewById(R.id.imgView);
        //btnCapture = (Button) findViewById(R.id.btnCapture);
        /*btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });*/


        mBtnNewUser = (Button) findViewById(R.id.btn_new_user);
        mBtnNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyApp.getInstance(), SignUpActivity.class);
                startActivity(intent);

            }
        });

        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
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
