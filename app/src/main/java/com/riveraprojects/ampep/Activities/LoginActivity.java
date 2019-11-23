package com.riveraprojects.ampep.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.riveraprojects.ampep.Activities.Test.TestActivity;
import com.riveraprojects.ampep.Models.Login;
import com.riveraprojects.ampep.Models.UsuarioSistema;
import com.riveraprojects.ampep.R;
import com.riveraprojects.ampep.Service.ApiService;
import com.riveraprojects.ampep.Service.ApiServiceGenerator;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout al_layout_main, al_layout_1, al_layout_1_1, al_layout_2;
    private EditText al_edt_user, al_edt_pass;
    private Button al_btn_signin;
    private ImageButton al_btn_usr, al_btn_tch;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private int idUsusist, idPersona, idTipoUsuSist;
    private String fechCreac, fecIniciacc, horIniciacc, fecFinacc, horFinacc;
    private String usuario, contrasen, estado, nameTipoUsuSist;

    private ApiService service;

    private static String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        uploadSettings();
        uploadPreferences();
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
        al_btn_usr = findViewById(R.id.al_btn_usr);
        al_btn_tch = findViewById(R.id.al_btn_tch);
        al_btn_signin.setOnClickListener(this);
        al_btn_usr.setOnClickListener(this);
        al_btn_tch.setOnClickListener(this);
    }

    private void uploadSettings() {
        service = ApiServiceGenerator.createService(ApiService.class);
    }

    private void uploadPreferences() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
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

            editor = sharedPreferences.edit();
            int charge = 0;
            if (user.equalsIgnoreCase("USR0001")) {
                charge = 1;
            } else if (user.equalsIgnoreCase("TCH0001")) {
                charge = 2;
            }

            editor
                    .putString("USER", user)
                    .putString("PASS", pass)
                    .putInt("CHARGE", charge)
                    .apply();

            goModuleActivity();
            //goTestActivity();
        } else {
            al_edt_user.requestFocus();
            Toast.makeText(LoginActivity.this, "Usuario o contraseña Incorrecto", Toast.LENGTH_SHORT).show();
        }
    }

    private void loginValidate() {
        usuario = al_edt_user.getText().toString();
        contrasen = al_edt_pass.getText().toString();
        if (usuario.length() < 1) {
            al_edt_user.requestFocus();
            Toast.makeText(LoginActivity.this, "Ingrese Usuario", Toast.LENGTH_SHORT).show();
            return;
        } else if (contrasen.length() < 1) {
            al_edt_pass.requestFocus();
            Toast.makeText(LoginActivity.this, "Ingrese Contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        login2();
    }

    private void loginBody() {
        Login login = new Login(
                usuario,
                contrasen
        );
        Call<UsuarioSistema> call = service.loginBody(login);

        call.enqueue(new Callback<UsuarioSistema>() {
            @Override
            public void onResponse(Call<UsuarioSistema> call, Response<UsuarioSistema> response) {
                int statusCode = response.code();
                Log.i(TAG, "HTTP status code : " + statusCode);
                Log.i(TAG, "Response Message : " + response.message());

                try {
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

                    editor
                            .putString("USR_USER", usuario)
                            .putString("USR_PASS", contrasen)
                            .putInt("USR_TYPE", idTipoUsuSist)
                            .putInt("USR_ID_PERSON", idPersona)
                            .putString("USR_TYPE_NAME", nameTipoUsuSist)
                            .putString("USR_DATE_CREATE", fechCreac)
                            .putString("USR_DATE_START", fecIniciacc)
                            .putString("USR_TIME_START", horIniciacc)
                            .putString("USR_DATE_END", fecFinacc)
                            .putString("USR_TIME_END", horFinacc)
                            .putString("USR_STATE", estado)
                            .apply();

                    goModuleActivity();
                    Toast.makeText(getApplicationContext(), "Bienvenido " + usuario, Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Log.e(TAG, "onThrowable: " + e.toString(), e);
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UsuarioSistema> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void login() {
        Call<List<UsuarioSistema>> call = service.login(usuario, contrasen);

        call.enqueue(new Callback<List<UsuarioSistema>>() {
            @Override
            public void onResponse(Call<List<UsuarioSistema>> call, Response<List<UsuarioSistema>> response) {
                try {
                    int statusCode = response.code();
                    Log.e(TAG, "HTTP status code : " + statusCode);
                    Log.i(TAG, "Response Message : " + response.message());

                    if (response.isSuccessful()) {
                        /*List<UsuarioSistema> usuarioSistemaList = response.body();
                        UsuarioSistema usuarioSistema = usuarioSistemaList.get();
                        String username = usuarioSistema.getUsuario();*/

                        editor
                                .putString("USR_USER", usuario)
                                .putString("USR_PASS", contrasen)
                                .putInt("USR_TYPE", idTipoUsuSist)
                                .putInt("USR_ID_PERSON", idPersona)
                                .putString("USR_TYPE_NAME", nameTipoUsuSist)
                                .putString("USR_DATE_CREATE", fechCreac)
                                .putString("USR_DATE_START", fecIniciacc)
                                .putString("USR_TIME_START", horIniciacc)
                                .putString("USR_DATE_END", fecFinacc)
                                .putString("USR_TIME_END", horFinacc)
                                .putString("USR_STATE", estado)
                                .apply();

                        goModuleActivity();
                        Toast.makeText(getApplicationContext(), "Bienvenido " + usuario, Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e) {
                    Log.e(TAG, "onThrowable: " + e.toString(), e);
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<UsuarioSistema>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void login2() {
        Call<UsuarioSistema> call = service.login2(usuario, contrasen);

        call.enqueue(new Callback<UsuarioSistema>() {
            @Override
            public void onResponse(Call<UsuarioSistema> call, Response<UsuarioSistema> response) {
                try {
                    int statusCode = response.code();
                    Log.e(TAG, "HTTP status code : " + statusCode);
                    Log.i(TAG, "Response Message : " + response.message());

                    if (response.isSuccessful()) {
                        UsuarioSistema usuarioSistema = response.body();

                        idUsusist = response.body().getIdUsusist();
                        idTipoUsuSist = response.body().getIdTipoUsuSist().getIdTipousu();
                        nameTipoUsuSist = response.body().getIdTipoUsuSist().getDescripci();
                        idPersona = response.body().getIdPersona();

                        fechCreac = response.body().getFechCreac().toString();
                        fecIniciacc = response.body().getFecIniciacc().toString();
                        horIniciacc = response.body().getFechCreac().toString();
                        fecFinacc = response.body().getFecFinacc().toString();
                        horFinacc = response.body().getFechCreac().toString();

                        editor
                                .putString("USR_USER", usuario)
                                .putString("USR_PASS", contrasen)
                                .putInt("USR_TYPE", idTipoUsuSist)
                                .putInt("USR_ID_PERSON", idPersona)
                                .putString("USR_TYPE_NAME", nameTipoUsuSist)
                                .putString("USR_DATE_CREATE", fechCreac)
                                .putString("USR_DATE_START", fecIniciacc)
                                .putString("USR_TIME_START", horIniciacc)
                                .putString("USR_DATE_END", fecFinacc)
                                .putString("USR_TIME_END", horFinacc)
                                .putString("USR_STATE", estado)
                                .apply();

                        goModuleActivity();
                    }
                } catch (Exception e) {
                    Log.e(TAG, "onThrowable: " + e.toString(), e);
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UsuarioSistema> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                //Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "CREDENCIALES INCORRECTAS", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void customOrientation() {
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270) {
            al_layout_main.setOrientation(LinearLayout.HORIZONTAL);
            //al_layout_main.setBackgroundResource(R.drawable.bg_grad_h);
            al_layout_1.setVisibility(View.GONE);
            al_layout_1_1.setVisibility(View.VISIBLE);
        }
    }

    private void goModuleActivity() {
        startActivity(new Intent(getApplicationContext(), ModulesAreaActivity.class)
                .putExtra("SEND_CODE", "CODE_LA"));
    }

    private void goStartupActivity() {
        startActivity(new Intent(getApplicationContext(), StartupActivity.class));
    }

    private void setControllers(String usr) {
        if (usr.equalsIgnoreCase("USR")) {
            al_edt_user.setText("drivera_usr");
            al_edt_pass.setText("usr");
        } else if (usr.equalsIgnoreCase("TCH")) {
            al_edt_user.setText("drivera_tch");
            al_edt_pass.setText("tch");
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
            case R.id.al_btn_usr:
                setControllers("USR");
                break;
            case R.id.al_btn_tch:
                setControllers("TCH");
                break;
        }
    }
}
