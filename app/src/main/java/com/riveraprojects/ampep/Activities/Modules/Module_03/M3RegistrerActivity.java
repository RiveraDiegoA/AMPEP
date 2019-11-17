package com.riveraprojects.ampep.Activities.Modules.Module_03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.riveraprojects.ampep.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class M3RegistrerActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout layout_main;
    private ImageView btn_camp_01, btn_camp_02;
    private EditText edt_camp_01, edt_camp_02, edt_camp_03, edt_camp_04;
    private Button btn_registrer;
    private Calendar customCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m3_registrer);

        init();
        customCalendar = Calendar.getInstance();
        customOrientation();
    }

    private void init() {
        layout_main = findViewById(R.id.am3r_layout_main);
        btn_camp_01 = findViewById(R.id.am3r_btn_camp_01);
        btn_camp_02 = findViewById(R.id.am3r_btn_camp_02);
        edt_camp_01 = findViewById(R.id.am3r_camp_01);
        edt_camp_02 = findViewById(R.id.am3r_camp_02);
        edt_camp_03 = findViewById(R.id.am3r_camp_03);
        edt_camp_04 = findViewById(R.id.am3r_camp_04);
        btn_registrer = findViewById(R.id.am3r_btn_registrer);

        btn_camp_01.setOnClickListener(this);
        btn_camp_02.setOnClickListener(this);
        btn_registrer.setOnClickListener(this);
    }

    private void showCalendar(final String btn) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                customCalendar.set(Calendar.YEAR, year);
                customCalendar.set(Calendar.MONTH, monthOfYear);
                customCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                if (btn.equalsIgnoreCase("btn_01")) {
                    setTextCamps("camp_01");
                } else if (btn.equalsIgnoreCase("btn_02")) {
                    setTextCamps("camp_02");
                }
            }
        }, customCalendar.get(Calendar.YEAR), customCalendar.get(Calendar.MONTH), customCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.getDatePicker().setMinDate(new Date().getTime());
        datePickerDialog.show();
    }

    private void setTextCamps(String camp) {
        String myFormat = "MM/dd/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        if (camp.equalsIgnoreCase("camp_01")) {
            edt_camp_01.setText(sdf.format(customCalendar.getTime()));
        } else if (camp.equalsIgnoreCase("camp_02")) {
            if (edt_camp_01.getText().toString().equalsIgnoreCase(sdf.format(customCalendar.getTime()))) {
                Toast.makeText(this, "FECHA DE FINALIZACIÓN, NO PUEDE SER IGUAL A LA FECHA DE INICIO", Toast.LENGTH_LONG).show();
            } else {
                edt_camp_02.setText(sdf.format(customCalendar.getTime()));
            }
        }
    }

    private void clearControllers() {
        edt_camp_01.setText("");
        edt_camp_02.setText("");
        edt_camp_03.setText("");
        edt_camp_04.setText("");
        edt_camp_01.requestFocus();
    }

    private void customOrientation() {
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270) {
            layout_main.setPadding(120, 20, 120, 20);
        }
    }

    private void goM3OptionsActivity() {
        startActivity(new Intent(getApplicationContext(), M3OptionsActivity.class));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        goM3OptionsActivity();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.am3r_btn_camp_01:
                showCalendar("btn_01");
                break;
            case R.id.am3r_btn_camp_02:
                showCalendar("btn_02");
                break;
            case R.id.am3r_btn_registrer:
                clearControllers();
                Toast.makeText(this, "REGISTRO EXITOSO", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
