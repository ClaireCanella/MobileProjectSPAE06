package com.claire.mobileprojectspae06.UI.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.claire.mobileprojectspae06.MyApp;
import com.claire.mobileprojectspae06.R;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Places;

public class UserRefugeActivity extends AppCompatActivity {

    private ImageView btnCall;
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_refuge);


        /*mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .addConnectionCallbacks((GoogleApiClient.ConnectionCallbacks) this)
                .addOnConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener) this)
                .build();*/


        btnCall = (ImageView) findViewById(R.id.imageView9);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:0630481339"));
                if (ActivityCompat.checkSelfPermission(MyApp.getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MyApp.getContext(), "Not permit", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(callIntent);
                }

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        //mGoogleApiClient.connect();
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

    @Override
    protected void onStop() {
        //mGoogleApiClient.disconnect();
        super.onStop();
    }

}
