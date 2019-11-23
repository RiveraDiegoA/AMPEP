package com.riveraprojects.ampep.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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
    private ImageButton btn_exit;
    private SharedPreferences sharedPreferences;
    private String user, pass;
    private int type;

    private static String TAG = ModulesAreaActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules_area);

        init();
        uploadPreferences();
        getIntentData();
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

    private void getIntentData() {
        Intent intent = getIntent();
        String code = intent.getStringExtra("SEND_CODE");

        if (code.equalsIgnoreCase("CODE_LA")) {
            showWelcomeDialog(user);
        } else {
            Log.d(TAG, "RETURN OF OTHER ACTIVITIES");
        }
    }

    private void uploadPreferences() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        user = sharedPreferences.getString("USR_USER", null);
        pass = sharedPreferences.getString("USR_PASS", null);
        type = sharedPreferences.getInt("USR_TYPE", 0);

        if (type == 3) {
            btn_01.setVisibility(View.GONE);
            btn_01_01.setVisibility(View.GONE);
            btn_02.setVisibility(View.GONE);
            btn_02_01.setVisibility(View.GONE);
        }
    }

    private void showWelcomeDialog(String user) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View child = LayoutInflater.from(this).inflate(R.layout.item_popup_welcome, null);
        builder.setView(child);

        final AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        alertDialog.show();

        TextView ipw_name = alertDialog.findViewById(R.id.ipw_name);
        Button ipw_btn = alertDialog.findViewById(R.id.ipw_btn);

        ipw_name.setText(user);

        ipw_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }

    private void customOrientation() {
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270) {
            layout_01.setVisibility(View.GONE);
            layout_02.setVisibility(View.VISIBLE);
            if (type == 3) {
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
                if (type == 2) {
                    activity = new M3ListActivity();
                } else if (type == 3) {
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
