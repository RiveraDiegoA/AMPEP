package com.riveraprojects.ampep.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.riveraprojects.ampep.Activities.Test.TestActivity;
import com.riveraprojects.ampep.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout al_layout_main, al_layout_1, al_layout_1_1, al_layout_2;
    private EditText al_edt_user, al_edt_pass;
    private Button al_btn_signin, al_btn_usr, al_btn_tch;
    private static final String[] PERMISSIONS_LIST = new String[]{
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        uploadPreferences();
        customOrientation();
    }

    private void init() {
        al_layout_main = findViewById(R.id.al_layout_main);
        al_layout_1 = findViewById(R.id.al_layout_1);
        al_layout_1_1 = findViewById(R.id.al_layout_1_1);
        al_layout_2 = findViewById(R.id.al_layout_2);
        al_edt_user = findViewById(R.id.al_edt_user);
        al_edt_pass = findViewById(R.id.al_edt_pass);
        al_btn_signin = findViewById(R.id.al_btn_signin);
        al_btn_usr = findViewById(R.id.al_btn_usr);
        al_btn_tch = findViewById(R.id.al_btn_tch);
        al_btn_signin.setOnClickListener(this);
        al_btn_usr.setOnClickListener(this);
        al_btn_tch.setOnClickListener(this);
    }

    private void uploadPreferences() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    private void simpleValidate() {
        String user = al_edt_user.getText().toString();
        String pass = al_edt_pass.getText().toString();
        if (user.length() < 1) {
            al_edt_user.requestFocus();
            Toast.makeText(LoginActivity.this, "Ingrese Usuario", Toast.LENGTH_SHORT).show();
            return;
        } else if (pass.length() < 1) {
            al_edt_pass.requestFocus();
            Toast.makeText(LoginActivity.this, "Ingrese Contraseña", Toast.LENGTH_SHORT).show();
            return;
        } else if (user.equals("USR0001") && pass.equals("PASS-USR") ||
                user.equals("TCH0001") && pass.equals("PASS-TCH")) {

            editor = sharedPreferences.edit();
            int charge = 0;
            if (user.equalsIgnoreCase("USR0001")) {
                charge = 1;
            } else if (user.equalsIgnoreCase("TCH0001")) {
                charge = 2;
            }

            editor
                    .putString("USER", user)
                    .putString("PASS", pass)
                    .putInt("CHARGE", charge)
                    .apply();

            goModuleActivity();
            //goTestActivity();
        } else {
            al_edt_user.requestFocus();
            Toast.makeText(LoginActivity.this, "Usuario o contraseña Incorrecto", Toast.LENGTH_SHORT).show();
        }
    }

    private void customOrientation() {
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270) {
            al_layout_main.setOrientation(LinearLayout.HORIZONTAL);
            //al_layout_main.setBackgroundResource(R.drawable.bg_grad_h);
            al_layout_1.setVisibility(View.GONE);
            al_layout_1_1.setVisibility(View.VISIBLE);
            //al_layout_2.setPadding(60, 0, 60, 0);
        }
    }

    private boolean permissionsGranted() {
        for (String permission : PERMISSIONS_LIST) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED)
                return false;
        }
        return true;
    }

    private void goModuleActivity() {
        startActivity(new Intent(getApplicationContext(), ModulesAreaActivity.class));
    }

    private void goTestActivity() {
        startActivity(new Intent(getApplicationContext(), TestActivity.class));
    }

    private void goStartupActivity() {
        startActivity(new Intent(getApplicationContext(), StartupActivity.class));
    }

    private void goPermissionsActivity() {
        startActivity(new Intent(getApplicationContext(), PermissionsActivity.class));
    }

    private void setControllers(String usr) {
        if (usr.equalsIgnoreCase("USR")) {
            al_edt_user.setText("USR0001");
            al_edt_pass.setText("PASS-USR");
        } else if (usr.equalsIgnoreCase("TCH")) {
            al_edt_user.setText("TCH0001");
            al_edt_pass.setText("PASS-TCH");
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        int versionSDK = Build.VERSION.SDK_INT;
        if (versionSDK >= Build.VERSION_CODES.M) {
            if (!permissionsGranted()) {
                goPermissionsActivity();
            } else {
                goStartupActivity();
            }
        } else {
            goStartupActivity();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.al_btn_signin:
                simpleValidate();
                break;
            case R.id.al_btn_usr:
                setControllers("USR");
                break;
            case R.id.al_btn_tch:
                setControllers("TCH");
                break;
        }
    }
}
