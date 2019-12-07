package com.riveraprojects.ampep.Activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.riveraprojects.ampep.Models.UsuarioSistema;
import com.riveraprojects.ampep.R;
import com.riveraprojects.ampep.Service.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout al_layout_main, al_layout_1, al_layout_1_1, al_layout_2;
    private EditText al_edt_user, al_edt_pass;
    private Button al_btn_signin;
    private ImageButton al_btn_settings, al_btn_usrs;

    private ProgressDialog progressDialog;

    private int idUsusist, idPersona, idTipoUsuSist;
    private String base_url_saved, phone_saved, fechCreac, fecIniciacc, horIniciacc, fecFinacc, horFinacc;
    private String username, password, estado, nameTipoUsuSist;

    private ApiService service;

    private static String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        getIntentData();
        uploadSettings();
        customOrientation();
    }

    private void init() {
        al_layout_main = findViewById(R.id.al_layout_main);
        al_layout_1 = findViewById(R.id.al_layout_1);
        al_layout_1_1 = findViewById(R.id.al_layout_1_1);
        al_layout_2 = findViewById(R.id.al_layout_2);
        al_edt_user = findViewById(R.id.al_edt_user);
        al_edt_pass = findViewById(R.id.al_edt_pass);
        al_btn_signin = findViewById(R.id.al_btn_signin);
        al_btn_usrs = findViewById(R.id.al_btn_usrs);
        al_btn_settings = findViewById(R.id.al_btn_settings);
        al_btn_signin.setOnClickListener(this);
        al_btn_settings.setOnClickListener(this);
        al_btn_usrs.setOnClickListener(this);
    }

    private void getIntentData() {
        Intent intent = getIntent();
        base_url_saved = intent.getStringExtra("BASE_URL");
        phone_saved = intent.getStringExtra("ASSISTANT_PHONE");
        Log.d(TAG, "URL_BASE: " + base_url_saved);
        Log.d(TAG, "ASSISTANT_PHONE: " + phone_saved);
    }

    private void uploadSettings() {
        //service = ApiServiceGenerator.createService(ApiService.class);
        /////////////////////////
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url_saved)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiService.class);
        /////////////////////////
    }

    private void simpleValidate() {
        String user = al_edt_user.getText().toString();
        String pass = al_edt_pass.getText().toString();
        if (user.length() < 1) {
            al_edt_user.requestFocus();
            Toast.makeText(LoginActivity.this, "Ingrese Usuario", Toast.LENGTH_SHORT).show();
            return;
        } else if (pass.length() < 1) {
            al_edt_pass.requestFocus();
            Toast.makeText(LoginActivity.this, "Ingrese Contraseña", Toast.LENGTH_SHORT).show();
            return;
        } else if (user.equals("USR0001") && pass.equals("PASS-USR") ||
                user.equals("TCH0001") && pass.equals("PASS-TCH")) {

            int charge = 0;
            if (user.equalsIgnoreCase("USR0001")) {
                charge = 1;
            } else if (user.equalsIgnoreCase("TCH0001")) {
                charge = 2;
            }

            goModuleActivity();
        } else {
            al_edt_user.requestFocus();
            Toast.makeText(LoginActivity.this, "Usuario o contraseña Incorrecto", Toast.LENGTH_SHORT).show();
        }
    }

    private void loginValidate() {
        username = al_edt_user.getText().toString();
        password = al_edt_pass.getText().toString();
        if (username.length() < 1) {
            al_edt_user.requestFocus();
            Toast.makeText(LoginActivity.this, "Ingrese Usuario", Toast.LENGTH_SHORT).show();
            return;
        } else if (password.length() < 1) {
            al_edt_pass.requestFocus();
            Toast.makeText(LoginActivity.this, "Ingrese Contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        login();
    }

    private void login() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Validando Credenciales...");
        progressDialog.show();

        Call<UsuarioSistema> call = service.login(username, password);

        call.enqueue(new Callback<UsuarioSistema>() {
            @Override
            public void onResponse(Call<UsuarioSistema> call, Response<UsuarioSistema> response) {
                try {
                    int statusCode = response.code();
                    Log.e(TAG, "HTTP status code : " + statusCode);
                    Log.i(TAG, "Response Message : " + response.message());

                    if (response.isSuccessful()) {

                        idUsusist = response.body().getIdUsusist();
                        idTipoUsuSist = response.body().getIdTipoUsuSist().getIdTipousu();
                        nameTipoUsuSist = response.body().getIdTipoUsuSist().getDescripci();
                        idPersona = response.body().getIdPersona();

                        fechCreac = response.body().getFechCreac().toString();
                        fecIniciacc = response.body().getFecIniciacc().toString();
                        horIniciacc = response.body().getFechCreac().toString();
                        fecFinacc = response.body().getFecFinacc().toString();
                        horFinacc = response.body().getFechCreac().toString();
                        estado = response.body().getEstado();

                        Log.e(TAG, "USR_USERNAME : " + username);
                        Log.e(TAG, "USR_PASS : " + password);
                        Log.e(TAG, "USR_ID : " + idUsusist);
                        Log.e(TAG, "USR_TYPE : " + idTipoUsuSist);
                        Log.e(TAG, "USR_TYPE_NAME : " + nameTipoUsuSist);
                        Log.e(TAG, "USR_ID_PERSON : " + idPersona);
                        Log.e(TAG, "USR_DATE_CREATE : " + fechCreac);
                        Log.e(TAG, "USR_DATE_START : " + fecIniciacc);
                        Log.e(TAG, "USR_TIME_START : " + horIniciacc);
                        Log.e(TAG, "USR_DATE_END : " + fecFinacc);
                        Log.e(TAG, "USR_TIME_END : " + horFinacc);
                        Log.e(TAG, "USR_STATE : " + estado);

                        if (idTipoUsuSist == 5 || idTipoUsuSist == 4) {
                            progressDialog.dismiss();
                            goModuleActivity();
                        } else {
                            progressDialog.dismiss();
                            Toast.makeText(LoginActivity.this, idTipoUsuSist + " EL USUARIO INGRESADO NO ESTA PERMITIDO.", Toast.LENGTH_LONG).show();
                            al_edt_user.selectAll();
                            al_edt_user.requestFocus();
                            return;
                        }
                    }
                } catch (Exception e) {
                    progressDialog.dismiss();
                    Log.e(TAG, "onThrowable: " + e.toString(), e);
                    Toast.makeText(getApplicationContext(), "Credenciales incorrectas.", Toast.LENGTH_SHORT).show();
                    al_edt_user.requestFocus();
                }
            }

            @Override
            public void onFailure(Call<UsuarioSistema> call, Throwable t) {
                progressDialog.dismiss();
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(getApplicationContext(), "Fallo en la conexión.", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void showAlertDialogUsers() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View child = LayoutInflater.from(this).inflate(R.layout.item_popup_users, null);
        builder.setView(child);

        final AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);
        alertDialog.show();

        Button ipusrs_btn_01 = alertDialog.findViewById(R.id.ipusrs_btn_01);
        Button ipusrs_btn_02 = alertDialog.findViewById(R.id.ipusrs_btn_02);
        Button ipusrs_btn_03 = alertDialog.findViewById(R.id.ipusrs_btn_03);
        Button ipusrs_btn_04 = alertDialog.findViewById(R.id.ipusrs_btn_04);

        ipusrs_btn_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setControllers("TCH_01");

                alertDialog.dismiss();
            }
        });

        ipusrs_btn_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setControllers("TCH_02");

                alertDialog.dismiss();
            }
        });

        ipusrs_btn_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setControllers("APO_01");

                alertDialog.dismiss();
            }
        });

        ipusrs_btn_04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setControllers("APO_02");

                alertDialog.dismiss();
            }
        });
    }

    private void customOrientation() {
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270) {
            al_layout_main.setOrientation(LinearLayout.HORIZONTAL);
            al_layout_1.setVisibility(View.GONE);
            al_layout_1_1.setVisibility(View.VISIBLE);
        }
    }

    private void goModuleActivity() {
        startActivity(new Intent(getApplicationContext(), ModulesAreaActivity.class)
                .putExtra("SEND_CODE", "CODE_LA")
                .putExtra("USR_USERNAME", username)
                .putExtra("USR_PASS", password)
                .putExtra("USR_ID", idUsusist)
                .putExtra("USR_ID_PERSON", idPersona)
                .putExtra("USR_TYPE_ID", idTipoUsuSist)
                .putExtra("USR_TYPE_NAME", nameTipoUsuSist)
                .putExtra("USR_DATE_CREATE", fechCreac)
                .putExtra("USR_DATE_START", fecIniciacc)
                .putExtra("USR_TIME_START", horIniciacc)
                .putExtra("USR_DATE_END", fecFinacc)
                .putExtra("USR_TIME_END", horFinacc)
                .putExtra("USR_STATE", estado)
                .putExtra("BASE_URL", base_url_saved)
                .putExtra("ASSISTANT_PHONE", phone_saved)
        );
    }

    private void goStartupActivity() {
        startActivity(new Intent(getApplicationContext(), StartupActivity.class));
    }

    private void goSettingsActivity() {
        startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
    }

    private void setControllers(String usr) {
        if (usr.equalsIgnoreCase("TCH_01")) {
            al_edt_user.setText("diegorivera.a04@gmail.com");
            al_edt_pass.setText("PFRIV70077156");
        } else if (usr.equalsIgnoreCase("TCH_02")) {
            al_edt_user.setText("riquelme@gmail.com");
            al_edt_pass.setText("PFRIQ46548687");
        } else if (usr.equalsIgnoreCase("APO_01")) {
            al_edt_user.setText("roxana@gmail.com");
            al_edt_pass.setText("APRIV76456165");
        } else if (usr.equalsIgnoreCase("APO_02")) {
            al_edt_user.setText("denisse@gmail.com");
            al_edt_pass.setText("APRIV78436514");
        }
    }

    @Override
    public void onBackPressed() {
        goStartupActivity();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.al_btn_signin:
                loginValidate();
                break;
            case R.id.al_btn_settings:
                goSettingsActivity();
                break;
            case R.id.al_btn_usrs:
                showAlertDialogUsers();
                break;
        }
    }
}
