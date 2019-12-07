package com.riveraprojects.ampep.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.riveraprojects.ampep.R;

public class StartupActivity extends AppCompatActivity {

    private static final int PERMISSIONS_REQUEST = 200;
    private static final String[] PERMISSIONS_LIST = new String[]{
            Manifest.permission.INTERNET,
            /*Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.CAMERA,*/
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                int versionSDK = Build.VERSION.SDK_INT;
                if (versionSDK >= Build.VERSION_CODES.M) {
                    if (!permissionsGranted()) {
                        startActivity(new Intent(getApplicationContext(), PermissionsActivity.class));
                    } else {
                        startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                    }
                } else {
                    startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                }
            }
        }, 1500);
    }

    private boolean permissionsGranted() {
        for (String permission : PERMISSIONS_LIST) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED)
                return false;
        }
        return true;
    }
}
