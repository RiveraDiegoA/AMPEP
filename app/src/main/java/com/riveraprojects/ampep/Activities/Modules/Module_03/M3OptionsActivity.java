package com.riveraprojects.ampep.Activities.Modules.Module_03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.riveraprojects.ampep.Activities.ModulesAreaActivity;
import com.riveraprojects.ampep.R;

public class M3OptionsActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout layout_01, layout_02;
    private CardView btn_01, btn_01_01, btn_02, btn_02_01;

    private int user_id, user_prof_id_colegio, idTipoUsuSist;
    private String user_patname, user_matname, user_name, user_telefono, user_correo, user_dni, base_url_saved, phone_saved;

    private static String TAG = M3RegistrerActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m3_options);

        init();
        getIntentData();
        customOrientation();
    }

    private void init() {
        layout_01 = findViewById(R.id.am3o_layout_01);
        layout_02 = findViewById(R.id.am3o_layout_02);
        btn_01 = findViewById(R.id.am3o_btn_01);
        btn_01_01 = findViewById(R.id.am3o_btn_01_01);
        btn_02 = findViewById(R.id.am3o_btn_02);
        btn_02_01 = findViewById(R.id.am3o_btn_02_01);

        btn_01.setOnClickListener(this);
        btn_01_01.setOnClickListener(this);
        btn_02.setOnClickListener(this);
        btn_02_01.setOnClickListener(this);
    }

    private void getIntentData() {
        Intent intent = getIntent();
        user_id = intent.getIntExtra("USR_ID", 0);
        idTipoUsuSist = intent.getIntExtra("USR_TYPE_ID", 0);
        user_patname = intent.getStringExtra("USR_PATNAME");
        user_matname = intent.getStringExtra("USR_MATNAME");
        user_name = intent.getStringExtra("USR_NAME");
        user_telefono = intent.getStringExtra("USR_TELEF");
        user_correo = intent.getStringExtra("USR_CORREO");
        user_dni = intent.getStringExtra("USR_DNI");
        user_prof_id_colegio = intent.getIntExtra("USR_PROF_ID_COLE", 0);

        base_url_saved = intent.getStringExtra("BASE_URL");
        phone_saved = intent.getStringExtra("ASSISTANT_PHONE");

        Log.d(TAG, "ASSISTANT_PHONE: " + phone_saved);
        Log.d(TAG, "URL_BASE: " + base_url_saved);
    }

    private void customOrientation() {
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270) {
            layout_01.setVisibility(View.GONE);
            layout_02.setVisibility(View.VISIBLE);
        }
    }

    private void goActivities(String module) {
        Activity activity = null;
        switch (module) {
            case "M1":
                activity = new M3ListActivity();
                break;
            case "M2":
                activity = new M3RegistrerActivity();
                break;
        }

        startActivity(new Intent(getApplicationContext(), activity.getClass())
                .putExtra("USR_ID", user_id)
                .putExtra("USR_PATNAME", user_patname)
                .putExtra("USR_MATNAME", user_matname)
                .putExtra("USR_NAME", user_name)
                .putExtra("USR_TELEF", user_telefono)
                .putExtra("USR_CORREO", user_correo)
                .putExtra("USR_DNI", user_dni)
                .putExtra("USR_PROF_ID_COLE", user_prof_id_colegio)
                .putExtra("BASE_URL", base_url_saved)
                .putExtra("ASSISTANT_PHONE", phone_saved)
                .putExtra("USR_TYPE_ID", idTipoUsuSist)
        );
    }

    private void goModulesAreaActivity() {
        startActivity(new Intent(getApplicationContext(), ModulesAreaActivity.class)
                .putExtra("USR_ID", user_id)
                .putExtra("SEND_CODE", "CODE_M3OA")
                .putExtra("USR_TYPE_ID", idTipoUsuSist)
                .putExtra("BASE_URL", base_url_saved)
                .putExtra("ASSISTANT_PHONE", phone_saved)
        );
    }

    @Override
    public void onBackPressed() {
        goModulesAreaActivity();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.am3o_btn_01:
                goActivities("M1");
                break;
            case R.id.am3o_btn_01_01:
                goActivities("M1");
                break;
            case R.id.am3o_btn_02:
                goActivities("M2");
                break;
            case R.id.am3o_btn_02_01:
                goActivities("M2");
                break;
        }
    }
}
