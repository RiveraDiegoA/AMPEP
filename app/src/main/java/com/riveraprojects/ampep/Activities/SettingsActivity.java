package com.riveraprojects.ampep.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.riveraprojects.ampep.R;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private static String TAG = SettingsActivity.class.getSimpleName();
    private EditText edt_ip, edt_port, edt_phone;
    private Button btn_save;

    private String sp_ip, sp_port, sp_base_url, sp_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        init();
    }

    private void init() {
        edt_ip = findViewById(R.id.astgns_edt_ip);
        edt_port = findViewById(R.id.astgns_edt_port);
        edt_phone = findViewById(R.id.astgns_edt_phone);
        btn_save = findViewById(R.id.astgns_btn_save);
        btn_save.setOnClickListener(this);
    }

    private void savePreferences() {
        sp_ip = edt_ip.getText().toString();
        sp_port = edt_port.getText().toString();
        sp_phone = edt_phone.getText().toString();

        if (sp_ip.isEmpty()) {
            edt_ip.requestFocus();
            Toast.makeText(SettingsActivity.this, "Ingrese IP", Toast.LENGTH_SHORT).show();
        } else if (sp_ip.isEmpty()) {
            edt_port.requestFocus();
            Toast.makeText(SettingsActivity.this, "Ingrese Puerto", Toast.LENGTH_SHORT).show();
        } else if (sp_phone.isEmpty()) {
            edt_phone.requestFocus();
            Toast.makeText(SettingsActivity.this, "Ingrese Teléfono", Toast.LENGTH_SHORT).show();
        } else {
            sp_base_url = "http://" + sp_ip + ":" + sp_port + "/ampep/";

            Log.i(TAG, "URL_BASE : " + sp_base_url);

            goLoginActivity(sp_base_url, sp_phone);
        }
    }

    private void goLoginActivity(String base_url, String phone) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class)
                .putExtra("BASE_URL", base_url)
                .putExtra("ASSISTANT_PHONE", phone)
        );

        Log.d(TAG, "ASSISTANT_PHONE: " + phone);
        Log.d(TAG, "URL_BASE: " + base_url);
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.astgns_btn_save:
                savePreferences();
                break;
        }
    }
}
