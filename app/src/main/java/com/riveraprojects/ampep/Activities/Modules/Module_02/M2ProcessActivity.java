package com.riveraprojects.ampep.Activities.Modules.Module_02;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.riveraprojects.ampep.Activities.ModulesAreaActivity;
import com.riveraprojects.ampep.R;
import com.shuhart.stepview.StepView;

public class M2ProcessActivity extends AppCompatActivity implements View.OnClickListener {

    private int currentStep, user_id, idTipoUsuSist;
    private StepView stepView;
    private LinearLayout layout_main;
    private CardView cardView_01, cardView_02, cardView_03, cardView_04;
    private Button btn_c1_01, btn_c1_02, btn_c2_01, btn_c2_02, btn_c3_01, btn_c3_02, btn_c4_01, btn_c4_02;

    private String base_url_saved, phone_saved;

    private static String TAG = M2ProcessActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m2_process);

        init();
        getIntentData();
        uploadSettingsStepview();
    }

    private void init() {
        stepView = findViewById(R.id.step_view);
        layout_main = findViewById(R.id.am2p_layout_main);
        cardView_01 = findViewById(R.id.am2p_cardview_01);
        cardView_02 = findViewById(R.id.am2p_cardview_02);
        cardView_03 = findViewById(R.id.am2p_cardview_03);
        cardView_04 = findViewById(R.id.am2p_cardview_04);
        btn_c1_01 = findViewById(R.id.am2p_c1_btn_01);
        btn_c1_02 = findViewById(R.id.am2p_c1_btn_02);
        btn_c2_01 = findViewById(R.id.am2p_c2_btn_01);
        btn_c2_02 = findViewById(R.id.am2p_c2_btn_02);
        btn_c3_01 = findViewById(R.id.am2p_c3_btn_01);
        btn_c3_02 = findViewById(R.id.am2p_c3_btn_02);
        btn_c4_01 = findViewById(R.id.am2p_c4_btn_01);
        btn_c4_02 = findViewById(R.id.am2p_c4_btn_02);
        btn_c1_01.setOnClickListener(this);
        btn_c1_02.setOnClickListener(this);
        btn_c2_01.setOnClickListener(this);
        btn_c2_02.setOnClickListener(this);
        btn_c3_01.setOnClickListener(this);
        btn_c3_02.setOnClickListener(this);
        btn_c4_01.setOnClickListener(this);
        btn_c4_02.setOnClickListener(this);
    }

    private void getIntentData() {
        Intent intent = getIntent();
        user_id = intent.getIntExtra("USR_ID", 0);
        idTipoUsuSist = intent.getIntExtra("USR_TYPE_ID", 0);
        base_url_saved = intent.getStringExtra("BASE_URL");
        phone_saved = intent.getStringExtra("ASSISTANT_PHONE");
        Log.d(TAG, "ASSISTANT_PHONE: " + phone_saved);
        Log.d(TAG, "URL_BASE: " + base_url_saved);
    }

    private void uploadSettingsStepview() {
        stepView.setStepsNumber(4);
        stepView.go(0, true);
    }

    private void stepProgress(int step) {
        if (currentStep < stepView.getStepCount() - 1) {
            currentStep++;
            stepView.go(currentStep, true);
        } else {
            stepView.done(true);
        }

        if (step == 1) {
            cardView_01.setVisibility(View.GONE);
            cardView_02.setVisibility(View.VISIBLE);
            cardView_03.setVisibility(View.GONE);
            cardView_04.setVisibility(View.GONE);
        } else if (step == 2) {
            cardView_01.setVisibility(View.GONE);
            cardView_02.setVisibility(View.GONE);
            cardView_03.setVisibility(View.VISIBLE);
            cardView_04.setVisibility(View.GONE);
        } else if (step == 3) {
            cardView_01.setVisibility(View.GONE);
            cardView_02.setVisibility(View.GONE);
            cardView_03.setVisibility(View.GONE);
            cardView_04.setVisibility(View.VISIBLE);
            showSuccsessDialog();
        }
    }

    private void goModulesAreaActivity() {
        startActivity(new Intent(getApplicationContext(), ModulesAreaActivity.class)
                .putExtra("SEND_CODE", "CODE_M2PA")
                .putExtra("USR_ID", user_id)
                .putExtra("USR_TYPE_ID", idTipoUsuSist)
                .putExtra("BASE_URL", base_url_saved)
                .putExtra("ASSISTANT_PHONE", phone_saved)
        );
    }

    private void sendtoRepository(String web) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(web)));
    }

    private void showDialogCita() {
        AlertDialog.Builder builder = new AlertDialog.Builder(M2ProcessActivity.this);
        View child = LayoutInflater.from(M2ProcessActivity.this).inflate(R.layout.item_dialog, null);
        builder.setView(child);

        final AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        alertDialog.show();

        Button btn_1 = alertDialog.findViewById(R.id.id_btn);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }

    private void showSuccsessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View child = LayoutInflater.from(this).inflate(R.layout.item_popup_welcome, null);
        builder.setView(child);

        final AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);
        alertDialog.show();

        LinearLayout layout_01 = alertDialog.findViewById(R.id.ipw_layout_01);
        LinearLayout layout_03 = alertDialog.findViewById(R.id.ipw_layout_03);
        TextView ipw_title = alertDialog.findViewById(R.id.ipw_title);
        TextView ipw_name = alertDialog.findViewById(R.id.ipw_name);
        TextView ipw_desc = alertDialog.findViewById(R.id.ipw_desc);
        Button ipw_btn_03 = alertDialog.findViewById(R.id.ipw_btn_03);

        layout_01.setVisibility(View.GONE);
        layout_03.setVisibility(View.VISIBLE);
        ipw_name.setVisibility(View.INVISIBLE);
        ipw_title.setText("!Felicitaciones!");
        ipw_desc.setText("En hora buena, logro consolidar la solicitud de matricula.");

        ipw_btn_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }

    @Override
    public void onBackPressed() {
        goModulesAreaActivity();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.am2p_c1_btn_01:
                sendtoRepository("https://drive.google.com/drive/folders/1mhWZVr2mZ7SO25ozjZtCxyKSaV-yKEs1?usp=sharing");
                break;
            case R.id.am2p_c1_btn_02:
                stepProgress(1);
                break;
            case R.id.am2p_c2_btn_01:
                sendtoRepository("https://drive.google.com/drive/folders/1SJRdxMk11sxY5taidQzZtRhTidCScCeP?usp=sharing");
                break;
            case R.id.am2p_c2_btn_02:
                stepProgress(2);
                break;
            case R.id.am2p_c3_btn_01:
                showDialogCita();
                break;
            case R.id.am2p_c3_btn_02:
                stepProgress(3);
                break;
            case R.id.am2p_c4_btn_01:
                sendtoRepository("https://drive.google.com/drive/folders/1SJRdxMk11sxY5taidQzZtRhTidCScCeP?usp=sharing");
                break;
            case R.id.am2p_c4_btn_02:
                goModulesAreaActivity();
                break;
        }
    }
}
