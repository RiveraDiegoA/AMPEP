package com.riveraprojects.ampep.Activities.Modules.Module_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.riveraprojects.ampep.Activities.ModulesAreaActivity;
import com.riveraprojects.ampep.R;

public class M1AppointmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m1_appointment);
    }

    private void goModulesAreaActivity() {
        startActivity(new Intent(getApplicationContext(), ModulesAreaActivity.class));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
