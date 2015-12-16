package com.claire.mobileprojectspae06.UI;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.claire.mobileprojectspae06.R;

import java.io.File;
import java.io.IOException;

/**
 * Created by Claire on 14/12/2015.
 */
public class CameraDemoActivity extends Activity {
        Button btnTakePhoto;
        ImageView imgTakenPhoto;

        private static final int CAM_REQUEST = 1313;

        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.content_main);

            btnTakePhoto = (Button) findViewById(R.id.btnCapture);
            imgTakenPhoto = (ImageView) findViewById(R.id.imgView);

            btnTakePhoto.setOnClickListener(new btnTakePhotoClicker());
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CAM_REQUEST){
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            imgTakenPhoto.setImageBitmap(thumbnail);
        }

    }

    class btnTakePhotoClicker implements Button.OnClickListener{
        @Override
        public void onClick(View v){
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, CAM_REQUEST);
        }
    }

    }
