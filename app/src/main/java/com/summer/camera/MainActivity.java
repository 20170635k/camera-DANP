package com.summer.camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView intentCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentCamera=findViewById(R.id.intentCamera);
        intentCamera.setOnClickListener(callbackIntentCamera);

        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            String [] cameraId = cameraManager.getCameraIdList();
            Log.d("testing","it works");
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    View.OnClickListener callbackIntentCamera=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, 1);
            }
        }
    };
}