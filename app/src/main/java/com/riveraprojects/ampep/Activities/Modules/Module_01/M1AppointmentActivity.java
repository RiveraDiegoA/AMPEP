package com.riveraprojects.ampep.Activities.Modules.Module_01;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.riveraprojects.ampep.Activities.ModulesAreaActivity;
import com.riveraprojects.ampep.R;

public class M1AppointmentActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_call;
    private ImageButton btn_close;
    private String base_url_saved, phone_saved;
    private int user_id, idTipoUsuSist;

    private static final int REQUEST_CALL = 1;

    private static final String TAG = M1AppointmentActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m1_appointment);

        init();
        getIntentData();
    }

    private void getIntentData() {
        Intent intent = getIntent();
        user_id = intent.getIntExtra("USR_ID", 0);
        idTipoUsuSist = intent.getIntExtra("USR_TYPE_ID", 0);
        base_url_saved = intent.getStringExtra("BASE_URL");
        phone_saved = intent.getStringExtra("ASSISTANT_PHONE");
        Log.d(TAG, "URL_BASE: " + base_url_saved);
        Log.d(TAG, "ASSISTANT_PHONE: " + phone_saved);
    }

    private void init() {
        btn_call = findViewById(R.id.am1a_btn_call);
        btn_close = findViewById(R.id.am1a_btn_close);

        btn_call.setOnClickListener(this);
        btn_close.setOnClickListener(this);
    }

    private void showDialog(final String phone) {
        AlertDialog.Builder builder = new AlertDialog.Builder(M1AppointmentActivity.this);
        builder.setMessage("¿DESEA REALIZAR LA LLAMADA?")
                .setCancelable(false)
                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialContactPhone(phone);
                        Toast.makeText(getApplicationContext(), "" + phone, Toast.LENGTH_SHORT).show();
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

    private void dialContactPhone(String phone) {
        //startActivity(new Intent(Intent.ACTION_CALL, Uri.fromParts("tel:", phone, null)));
        if (phone.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + phone;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        } else {
            Toast.makeText(getApplicationContext(), "Número de teléfono no valido", Toast.LENGTH_SHORT).show();
        }
    }

    private void goModulesAreaActivity() {
        startActivity(new Intent(getApplicationContext(), ModulesAreaActivity.class)
                .putExtra("SEND_CODE", "CODE_M1AA")
                .putExtra("USR_ID", user_id)
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.am1a_btn_call:
                showDialog(phone_saved);
                break;
            case R.id.am1a_btn_close:
                onBackPressed();
                break;
        }
    }
}
