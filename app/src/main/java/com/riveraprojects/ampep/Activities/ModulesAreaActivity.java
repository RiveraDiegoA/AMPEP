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
import com.riveraprojects.ampep.Models.Apoderado;
import com.riveraprojects.ampep.Models.Profesor;
import com.riveraprojects.ampep.R;
import com.riveraprojects.ampep.Service.ApiService;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ModulesAreaActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout layout_01, layout_02;
    private CardView btn_01, btn_01_01, btn_02, btn_02_01, btn_03, btn_03_01;
    private ImageButton btn_exit;

    private SharedPreferences sharedPreferences;

    private ApiService service;

    private int idUsusist, idPersona, idTipoUsuSist;
    private String base_url_saved, phone_saved, fechCreac, fecIniciacc, horIniciacc, fecFinacc, horFinacc;
    private String username, password, estado, nameTipoUsuSist, user_fullname;

    ////////////////////////////////
    private int idProfeso, idColegioProf, idDistritProf;
    private String apePatern;
    private String apeMatern;
    private String nombres;
    private Date fechNacim;
    private String estado_prof;
    private String domicilio;
    private String telefono;
    private String celular;
    private String correo;
    private String gradInstr;
    private String direTraba;
    private String estaCivil;
    private String fotografi;
    private String nroRegpro;
    private String nroDniProfesor;
    ////////////////////////////////
    private int idApoderado, colegioApoderado, distritoApoderado;
    private String dniApoderado;
    private String tipApoderado;
    private String apepApoderado;
    private String apemApoderado;
    private String nomApoderado;
    private Date fecnacApoderado;
    private String estadoApoderado;
    private String domiciApoderado;
    private String telfApoderado;
    private String celuApoderado;
    private String correoApoderado;
    private String gradoinsApoderado;
    private String profeApoderado;
    private String ocupacApoderado;
    private String centrotrabApoderado;
    private String direcciApoderado;
    private String estcivApoderado;
    private String fotoApoderado;
    private Date fecregistroApoderado;
    ////////////////////////////////

    private static String TAG = ModulesAreaActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules_area);

        init();
        getIntentData();
        //uploadSettings();
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

        username = intent.getStringExtra("USR_USERNAME");
        password = intent.getStringExtra("USR_PASS");
        idUsusist = intent.getIntExtra("USR_ID", 0);
        idPersona = intent.getIntExtra("USR_ID_PERSON", 0);
        idTipoUsuSist = intent.getIntExtra("USR_TYPE_ID", 0);
        nameTipoUsuSist = intent.getStringExtra("USR_TYPE_NAME");

        fechCreac = intent.getStringExtra("USR_DATE_CREATE");
        fecIniciacc = intent.getStringExtra("USR_DATE_START");
        horIniciacc = intent.getStringExtra("USR_TIME_START");
        fecFinacc = intent.getStringExtra("USR_DATE_END");
        horFinacc = intent.getStringExtra("USR_TIME_END");
        estado = intent.getStringExtra("USR_STATE");

        base_url_saved = intent.getStringExtra("BASE_URL");
        phone_saved = intent.getStringExtra("ASSISTANT_PHONE");

        uploadSettings(base_url_saved);

        if (code.equalsIgnoreCase("CODE_LA")) {
            if (idTipoUsuSist == 4) {
                getApoderadoById();
            } else if (idTipoUsuSist == 5) {
                getProfedorById();
            }
        } else {
            Log.d(TAG, "RETURN OF OTHER ACTIVITIES");
        }

        if (idTipoUsuSist == 5) {
            btn_01.setVisibility(View.GONE);
            btn_01_01.setVisibility(View.GONE);
            btn_02.setVisibility(View.GONE);
            btn_02_01.setVisibility(View.GONE);
        }

        Log.d(TAG, "ASSISTANT_PHONE: " + phone_saved);
        Log.d(TAG, "URL_BASE: " + base_url_saved);
    }

    private void uploadSettings(String base_url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiService.class);
    }

    private void getProfedorById() {
        Call<Profesor> call = service.getProfesorById(idPersona);
        call.enqueue(new Callback<Profesor>() {
            @Override
            public void onResponse(Call<Profesor> call, Response<Profesor> response) {
                try {
                    int statusCode = response.code();
                    Log.e(TAG, "HTTP status code : " + statusCode);
                    Log.i(TAG, "Response Message : " + response.message());

                    if (response.isSuccessful()) {
                        idProfeso = response.body().getIdProfeso();
                        apePatern = response.body().getApePatern();
                        apeMatern = response.body().getApeMatern();
                        nombres = response.body().getNombres();
                        fechNacim = response.body().getFechNacim();
                        estado_prof = response.body().getEstado();
                        domicilio = response.body().getDomicilio();
                        telefono = response.body().getTelefono();
                        celular = response.body().getCelular();
                        correo = response.body().getCorreo();
                        gradInstr = response.body().getGradInstr();
                        direTraba = response.body().getDireTraba();
                        estaCivil = response.body().getEstaCivil();
                        fotografi = response.body().getFotografi();
                        nroRegpro = response.body().getNroRegpro();
                        nroDniProfesor = response.body().getNroDniProfesor();
                        idColegioProf = response.body().getIdColegioProf().getIdColegio();
                        idDistritProf = response.body().getIdDistritProf().getIdDistrito();

                        user_fullname = apePatern + " " + apeMatern + " " + nombres;
                        Log.e(TAG, "USER FULL NAME : " + apePatern + " " + apeMatern + " " + nombres);
                        showWelcomeDialog(user_fullname);
                    }
                } catch (Exception e) {
                    Log.e(TAG, "onThrowable: " + e.toString(), e);
                }
            }

            @Override
            public void onFailure(Call<Profesor> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
            }
        });
    }

    private void getApoderadoById() {
        Call<Apoderado> call = service.getApoderadoById(idPersona);
        call.enqueue(new Callback<Apoderado>() {
            @Override
            public void onResponse(Call<Apoderado> call, Response<Apoderado> response) {
                try {
                    int statusCode = response.code();
                    Log.e(TAG, "HTTP status code : " + statusCode);
                    Log.i(TAG, "Response Message : " + response.message());

                    if (response.isSuccessful()) {
                        idApoderado = response.body().getIdApoderado();
                        dniApoderado = response.body().getDniApoderado();
                        tipApoderado = response.body().getTipApoderado();
                        apepApoderado = response.body().getApepApoderado();
                        apemApoderado = response.body().getApemApoderado();
                        nomApoderado = response.body().getNomApoderado();
                        fecnacApoderado = response.body().getFecnacApoderado();
                        estadoApoderado = response.body().getEstadoApoderado();
                        domiciApoderado = response.body().getDomiciApoderado();
                        telfApoderado = response.body().getTelfApoderado();
                        celuApoderado = response.body().getCeluApoderado();
                        correoApoderado = response.body().getCorreoApoderado();
                        gradoinsApoderado = response.body().getGradoinsApoderado();
                        profeApoderado = response.body().getProfeApoderado();
                        ocupacApoderado = response.body().getOcupacApoderado();
                        centrotrabApoderado = response.body().getCentrotrabApoderado();
                        direcciApoderado = response.body().getDirecciApoderado();
                        estcivApoderado = response.body().getEstcivApoderado();
                        fotoApoderado = response.body().getFotoApoderado();
                        fecregistroApoderado = response.body().getFecregistroApoderado();
                        colegioApoderado = response.body().getColegioApoderado().getIdColegio();
                        distritoApoderado = response.body().getDistritoApoderado().getIdDistrito();

                        user_fullname = apepApoderado + " " + apemApoderado + " " + nomApoderado;
                        Log.e(TAG, "USER FULL NAME : " + apepApoderado + " " + apemApoderado + " " + nomApoderado);
                        showWelcomeDialog(user_fullname);
                    }
                } catch (Exception e) {
                    Log.e(TAG, "onThrowable: " + e.toString(), e);
                }
            }

            @Override
            public void onFailure(Call<Apoderado> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
            }
        });
    }

    private void showWelcomeDialog(String user) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View child = LayoutInflater.from(this).inflate(R.layout.item_popup_welcome, null);
        builder.setView(child);

        final AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);
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
            if (idTipoUsuSist == 5) {
                layout_02.setPadding(400, 0, 400, 0);
            }
        }
    }

    private void goActivities(String module) {
        Activity activity = null;
        switch (module) {
            case "M1":
                activity = new M1AppointmentActivity();
                break;
            case "M2":
                activity = new M2ProcessActivity();
                break;
            case "M3":
                if (idTipoUsuSist == 4) {
                    activity = new M3ListActivity();
                } else if (idTipoUsuSist == 5) {
                    activity = new M3OptionsActivity();
                }
                break;
        }

        int user_id = 0;
        String user_patname = "";
        String user_matname = "";
        String user_name = "";
        String user_telefono = "";
        String user_correo = "";
        String user_dni = "";
        int user_prof_id_colegio = 0;

        if (idTipoUsuSist == 4) {
            user_id = idApoderado;
            user_patname = apepApoderado;
            user_matname = apemApoderado;
            user_name = nomApoderado;
            user_telefono = celuApoderado;
            user_correo = correoApoderado;
            user_dni = dniApoderado;
        } else if (idTipoUsuSist == 5) {
            user_id = idProfeso;
            user_patname = apePatern;
            user_matname = apeMatern;
            user_name = nombres;
            user_telefono = celular;
            user_correo = correo;
            user_dni = nroDniProfesor;
            user_prof_id_colegio = idColegioProf;
        }

        startActivity(new Intent(getApplicationContext(), activity.getClass())
                .putExtra("USR_ID", user_id)
                .putExtra("USR_TYPE_ID", idTipoUsuSist)
                .putExtra("USR_PATNAME", user_patname)
                .putExtra("USR_MATNAME", user_matname)
                .putExtra("USR_NAME", user_name)
                .putExtra("USR_TELEF", user_telefono)
                .putExtra("USR_CORREO", user_correo)
                .putExtra("USR_DNI", user_dni)
                .putExtra("USR_PROF_ID_COLE", user_prof_id_colegio)
                .putExtra("BASE_URL", base_url_saved)
                .putExtra("ASSISTANT_PHONE", phone_saved)
        );
    }

    private void signOff() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ModulesAreaActivity.this);
        builder.setMessage("DESEA CERRAR SESSIÓN?")
                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class)
                                .putExtra("BASE_URL", base_url_saved)
                                .putExtra("ASSISTANT_PHONE", phone_saved)
                        );
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
