package com.riveraprojects.ampep.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Surface;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.riveraprojects.ampep.Activities.Modules.Module_01.M1AppointmentActivity;
import com.riveraprojects.ampep.Activities.Modules.Module_02.M2ProcessActivity;
import com.riveraprojects.ampep.Activities.Modules.Module_03.M3ListActivity;
import com.riveraprojects.ampep.Activities.Modules.Module_03.M3OptionsActivity;
import com.riveraprojects.ampep.Activities.Test.TestActivity;
import com.riveraprojects.ampep.R;

public class ModulesAreaActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout layout_01, layout_02;
    private CardView btn_01, btn_01_01, btn_02, btn_02_01, btn_03, btn_03_01;
    private ImageView btn_exit;
    private SharedPreferences sharedPreferences;
    private String user, pass;
    private int charge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules_area);

        init();
        uploadPreferences();
        customOrientation();
    }

    private void init() {
        layout_01 = findViewById(R.id.ama_layout_01);
        layout_02 = findViewById(R.id.ama_layout_02);
        btn_01 = findViewById(R.id.ama_btn_01);
        btn_01_01 = findViewById(R.id.ama_btn_01_01);
        btn_02 = findViewById(R.id.ama_btn_02);
        btn_02_01 = findViewById(R.id.ama_btn_02_01);
        btn_03 = findViewById(R.id.ama_btn_03);
        btn_03_01 = findViewById(R.id.ama_btn_03_01);
        btn_exit = findViewById(R.id.ama_btn_exit);

        btn_01.setOnClickListener(this);
        btn_01_01.setOnClickListener(this);
        btn_02.setOnClickListener(this);
        btn_02_01.setOnClickListener(this);
        btn_03.setOnClickListener(this);
        btn_03_01.setOnClickListener(this);
        btn_exit.setOnClickListener(this);
    }

    private void uploadPreferences() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        user = sharedPreferences.getString("USER", null);
        pass = sharedPreferences.getString("PASS", null);
        charge = sharedPreferences.getInt("CHARGE", 0);

        if (charge == 2) {
            btn_01.setVisibility(View.GONE);
            btn_01_01.setVisibility(View.GONE);
            btn_02.setVisibility(View.GONE);
            btn_02_01.setVisibility(View.GONE);
        }
    }

    private void customOrientation() {
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270) {
            layout_01.setVisibility(View.GONE);
            layout_02.setVisibility(View.VISIBLE);
            if (charge == 2) {
                layout_02.setPadding(400, 0, 400, 0);
            }
        }
    }

    private void goActivities(String module) {
        Activity activity = null;
        switch (module) {
            case "M1":
                activity = new TestActivity();
                break;
            case "M2":
                activity = new M2ProcessActivity();
                break;
            case "M3":
                if (charge == 1) {
                    activity = new M3ListActivity();
                } else if (charge == 2) {
                    activity = new M3OptionsActivity();
                }
                break;
        }

        startActivity(new Intent(getApplicationContext(), activity.getClass()));
    }

    private void signOff() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ModulesAreaActivity.this);
        builder.setMessage("DESEA CERRAR SESSIÓN?")
                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        builder.create();
        builder.show();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "CIERRE SESSIÓN", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ama_btn_01:
                goActivities("M1");
                break;
            case R.id.ama_btn_01_01:
                goActivities("M1");
                break;
            case R.id.ama_btn_02:
                goActivities("M2");
                break;
            case R.id.ama_btn_02_01:
                goActivities("M2");
                break;
            case R.id.ama_btn_03:
                goActivities("M3");
                break;
            case R.id.ama_btn_03_01:
                goActivities("M3");
                break;
            case R.id.ama_btn_exit:
                signOff();
                break;
        }
    }
}
