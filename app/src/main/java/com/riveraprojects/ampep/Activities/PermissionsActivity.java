package com.riveraprojects.ampep.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.riveraprojects.ampep.R;

public class PermissionsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = PermissionsActivity.class.getSimpleName();
    private static final int PERMISSIONS_REQUEST = 200;
    private static final String[] PERMISSIONS_LIST = new String[]{
            Manifest.permission.INTERNET,
            /*Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.CAMERA,*/
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CALL_PHONE
    };

    private LinearLayout ap_layout_main, ap_layout_1, ap_layout_2;
    private ImageView ap_img;
    private Button ap_btn_permission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);

        init();
        customOrientation();
    }

    private void init() {
        ap_layout_main = findViewById(R.id.ap_layout_main);
        ap_layout_1 = findViewById(R.id.ap_layout_1);
        ap_layout_2 = findViewById(R.id.ap_layout_2);
        ap_img = findViewById(R.id.ap_img);
        ap_btn_permission = findViewById(R.id.ap_btn_permission);
        ap_btn_permission.setOnClickListener(this);
    }

    private void showPermissionsRequest() {
        ActivityCompat.requestPermissions(this, PERMISSIONS_LIST, PERMISSIONS_REQUEST);
    }

    private boolean permissionsGranted() {
        for (String permission : PERMISSIONS_LIST) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED)
                return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST: {
                for (int i = 0; i < grantResults.length; i++) {
                    Log.d(TAG, "" + grantResults[i]);
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "Debe aceptar todos los permisos!", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "PERMISSION DENIED: " + PERMISSIONS_LIST[i]);
                        return;
                    }
                }

                Toast.makeText(this, "Permisos concedidos", Toast.LENGTH_SHORT).show();

                goSettingsActivity();
            }
        }
    }

    private void customOrientation() {
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270) {
            ap_layout_main.setOrientation(LinearLayout.HORIZONTAL);
            //ap_img.setImageResource(R.drawable.img_logo_ampep);
            ap_layout_1.setGravity(Gravity.CENTER);
            ap_layout_2.setGravity(Gravity.CENTER);
            ap_layout_2.setPadding(0, 0, 0, 0);
        }
    }

    private void goStartupActivity() {
        startActivity(new Intent(getApplicationContext(), StartupActivity.class));
    }

    private void goSettingsActivity() {
        startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        goStartupActivity();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ap_btn_permission:
                showPermissionsRequest();
                break;
        }
    }

}
