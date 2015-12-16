package com.claire.mobileprojectspae06.UI.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.claire.mobileprojectspae06.Model.User;
import com.claire.mobileprojectspae06.R;
import com.claire.mobileprojectspae06.UI.adapters.AnimalsAdapter;
import com.parse.Parse;
import com.parse.ParseObject;

public class MainActivity extends AppCompatActivity {

    private Button btn_new_user;
    private Button buttonValidate;
    private RelativeLayout relativeLayout;
    private EditText emailEditText;
    private EditText pwdEditText;
    private ImageView mImageView;
    private Button btnCapture;
    private Button saveButton;

    private AnimalsAdapter animalsAdapter;


    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);



        btn_new_user = (Button) findViewById(R.id.btn_new_user);
        buttonValidate = (Button) findViewById(R.id.btn_login);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        emailEditText = (EditText) findViewById(R.id.email_address);
        pwdEditText = (EditText) findViewById(R.id.password);
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

        btn_new_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.signup_view);
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailEditText.getText().length() > 0 && pwdEditText.getText().length() > 0)
                {
                    //try to convert the editTextScore text to float, if fail, go to catch.
                        //create a new movie
                        User user = new User(emailEditText.getText().toString(),pwdEditText.getText().toString());
                }
                else
                {
                    //call custom Error Method showError
                    showError("Un des champs est vide.");
                }
            }
        };

        saveButton = (Button) findViewById(R.id.save_button);

        /*ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();*/
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


    private void showError(String errorMessage) {
        //create a new alertDialog Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //set the alert title.
        builder.setTitle("Erreur");
        //set the body text
        builder.setMessage(errorMessage);
        //add a OK button who do nothing.
        builder.setPositiveButton("OK", null);
        //create the AlertDialog from the builder
        AlertDialog alertDialog = builder.create();
        //show the alert dialog
        alertDialog.show();
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
