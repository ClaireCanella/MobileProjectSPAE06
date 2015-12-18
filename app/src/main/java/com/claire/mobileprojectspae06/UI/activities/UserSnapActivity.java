package com.claire.mobileprojectspae06.UI.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.claire.mobileprojectspae06.MyApp;
import com.claire.mobileprojectspae06.R;

public class UserSnapActivity extends AppCompatActivity {

    private ImageView btnCall;
    private ImageView imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_snap);

        //Bouton pour appeler directement le numéro entré au préalable
        btnCall = (ImageView) findViewById(R.id.imageView13);
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

        imageButton = (ImageView) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MyApp.getInstance(), UserProfileActivity.class);
                startActivity(intent);
            }
        });
    }

}
