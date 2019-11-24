package com.riveraprojects.ampep.Activities.Modules.Module_03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m3_options);

        init();
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

        startActivity(new Intent(getApplicationContext(), activity.getClass()));
    }

    private void goModulesAreaActivity() {
        startActivity(new Intent(getApplicationContext(), ModulesAreaActivity.class));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //goModulesAreaActivity();
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
