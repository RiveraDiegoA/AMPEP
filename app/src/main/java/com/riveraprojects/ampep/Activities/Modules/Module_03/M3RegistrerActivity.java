package com.riveraprojects.ampep.Activities.Modules.Module_03;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.riveraprojects.ampep.Models.Anuncio;
import com.riveraprojects.ampep.Models.Colegio;
import com.riveraprojects.ampep.Models.GradoEscolar;
import com.riveraprojects.ampep.Models.UsuarioSistema;
import com.riveraprojects.ampep.R;
import com.riveraprojects.ampep.Service.ApiService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class M3RegistrerActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout layout_main;
    private TextView text_01, text_02;
    private ImageView btn_camp_01, btn_camp_02;
    private EditText edt_camp_01, edt_camp_02, edt_camp_03, edt_camp_04;
    private String camp_01, camp_02, camp_03, camp_04;
    private String reg_camp_01, reg_camp_02, reg_camp_03, reg_camp_04;
    private Date date_01, date_02, reg_date_01, reg_date_02, reg_date_03;
    private SimpleDateFormat sdf_show, sdf_reg;
    private String myFormatShow, myFormatReg, currentDate;
    private Button btn_registrer;
    private ImageButton btn_back;
    private Calendar customCalendar;
    private Spinner spinner_colegio, spinner_grado;
    private ProgressDialog progressDialog;

    private int user_id, user_prof_id_colegio, idTipoUsuSist;
    private String user_patname, user_matname, user_name, user_telefono, user_correo, user_dni;

    private int idAnuncio, colegioAnuncio_id, gradoAnuncio_id, usuariosisAnuncio_id;
    private String titAnuncio, descAnuncio, estadoAnuncio, colegioAnuncio_name, gradoAnuncio_desc, usuariosisAnuncio_fullname;
    private Date fecRegAnuncio, fecinAnuncio, fecfinAnuncio;

    private String[] items_colegio, items_grado;
    private Integer[] items_colegio_id, items_grado_id;

    private String base_url_saved, phone_saved;

    private ApiService service;

    private static final String TAG = M3RegistrerActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m3_registrer);

        init();
        getIntentData();
        customOrientation();
    }

    private void init() {
        layout_main = findViewById(R.id.am3r_layout_main);
        text_01 = findViewById(R.id.am3r_title_01);
        text_02 = findViewById(R.id.am3r_title_02);
        btn_camp_01 = findViewById(R.id.am3r_btn_camp_01);
        btn_camp_02 = findViewById(R.id.am3r_btn_camp_02);
        edt_camp_01 = findViewById(R.id.am3r_camp_01);
        edt_camp_02 = findViewById(R.id.am3r_camp_02);
        edt_camp_03 = findViewById(R.id.am3r_camp_03);
        edt_camp_04 = findViewById(R.id.am3r_camp_04);
        btn_back = findViewById(R.id.am3r_btn_close);
        btn_registrer = findViewById(R.id.am3r_btn_registrer);
        spinner_colegio = findViewById(R.id.am3r_spinner_01);
        spinner_grado = findViewById(R.id.am3r_spinner_02);

        btn_camp_01.setOnClickListener(this);
        btn_camp_02.setOnClickListener(this);
        btn_back.setOnClickListener(this);
        btn_registrer.setOnClickListener(this);
    }

    private void getIntentData() {
        Intent intent = getIntent();
        base_url_saved = intent.getStringExtra("BASE_URL");
        phone_saved = intent.getStringExtra("ASSISTANT_PHONE");

        user_id = intent.getIntExtra("USR_ID", 0);
        idTipoUsuSist = intent.getIntExtra("USR_TYPE_ID", 0);
        user_patname = intent.getStringExtra("USR_PATNAME");
        user_matname = intent.getStringExtra("USR_MATNAME");
        user_name = intent.getStringExtra("USR_NAME");
        user_telefono = intent.getStringExtra("USR_TELEF");
        user_correo = intent.getStringExtra("USR_CORREO");
        user_dni = intent.getStringExtra("USR_DNI");
        user_prof_id_colegio = intent.getIntExtra("USR_PROF_ID_COLE", 0);

        uploadSettings(base_url_saved);

        Log.d(TAG, "USR_ID: " + user_id);
        Log.d(TAG, "USR_ID_COLEGIO: " + user_prof_id_colegio);
        Log.d(TAG, "ASSISTANT_PHONE: " + phone_saved);
        Log.d(TAG, "URL_BASE: " + base_url_saved);

        //Toast.makeText(this, "USR_ID: " + user_id + "\n" + "USR_ID_COLEGIO: " + user_prof_id_colegio + "\n" + "ASSISTANT_PHONE: " + phone_saved + "\n" + "URL_BASE: " + base_url_saved, Toast.LENGTH_SHORT).show();
    }

    private void uploadSettings(String base_url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiService.class);

        customCalendar = Calendar.getInstance();
        myFormatShow = "dd-MM-yyyy";
        myFormatReg = "yyyy-MM-dd HH:mm:ss";
        sdf_show = new SimpleDateFormat(myFormatShow, Locale.US);
        sdf_reg = new SimpleDateFormat(myFormatShow, Locale.US);
        currentDate = sdf_reg.format(customCalendar.getTime());

        getColegioById();
        getGradoById();
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
        if (camp.equalsIgnoreCase("camp_01")) {
            edt_camp_01.setText(sdf_show.format(customCalendar.getTime()));
            reg_camp_01 = sdf_reg.format(customCalendar.getTime());
        } else if (camp.equalsIgnoreCase("camp_02")) {
            String getDate_01 = edt_camp_01.getText().toString();
            String getDate_02 = sdf_show.format(customCalendar.getTime());

            try {
                date_01 = sdf_show.parse(getDate_01);
                date_02 = sdf_show.parse(getDate_02);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (date_02.equals(date_01)) {
                Toast.makeText(this, "LA FECHA DE FINALIZACIÓN, NO PUEDE SER IGUAL A LA FECHA DE INICIO", Toast.LENGTH_LONG).show();
                return;
            } else if (date_02.before(date_01)) {
                Toast.makeText(this, "LA FECHA DE FINALIZACIÓN, NO PUEDE SER MENOR A LA FECHA DE INICIO", Toast.LENGTH_LONG).show();
            } else {
                edt_camp_02.setText(sdf_show.format(customCalendar.getTime()));
                reg_camp_02 = sdf_reg.format(customCalendar.getTime());
            }
        }
    }

    private void clearControllers() {
        edt_camp_01.setText("");
        edt_camp_02.setText("");
        edt_camp_03.setText("");
        edt_camp_04.setText("");
        text_01.requestFocus();
    }

    private void getColegioById() {
        Call<List<Colegio>> call = service.getColegio();
        call.enqueue(new Callback<List<Colegio>>() {
            @Override
            public void onResponse(Call<List<Colegio>> call, Response<List<Colegio>> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        List<Colegio> colegios = response.body();

                        Log.i(TAG, "Colegio cantidad : " + colegios.size());

                        items_colegio = new String[colegios.size()];
                        items_colegio_id = new Integer[colegios.size()];

                        for (int i = 0; i < colegios.size(); i++) {
                            items_colegio[i] = colegios.get(i).getNomColegio();
                            items_colegio_id[i] = colegios.get(i).getIdColegio();
                        }

                        ArrayAdapter<String> adapter;
                        adapter = new ArrayAdapter<>(M3RegistrerActivity.this, R.layout.spinner_item, items_colegio);
                        adapter.setDropDownViewResource(R.layout.spinner_item);

                        spinner_colegio.setAdapter(adapter);

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    Log.e(TAG, "onThrowable: " + t.toString(), t);
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Colegio>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(getApplicationContext(), "Fallo en la conexión.", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getGradoById() {
        Call<List<GradoEscolar>> call = service.getGradoEscolar();
        call.enqueue(new Callback<List<GradoEscolar>>() {
            @Override
            public void onResponse(Call<List<GradoEscolar>> call, Response<List<GradoEscolar>> response) {
                try {
                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        List<GradoEscolar> grados = response.body();

                        Log.i(TAG, "Colegio cantidad : " + grados.size());

                        items_grado = new String[grados.size()];
                        items_grado_id = new Integer[grados.size()];

                        for (int i = 0; i < grados.size(); i++) {
                            items_grado[i] = grados.get(i).getDescripcionGradoEscolar() + " " + grados.get(i).getNivelGradoEscolar();
                            items_grado_id[i] = grados.get(i).getIdGrado();
                        }

                        ArrayAdapter<String> adapter;
                        adapter = new ArrayAdapter<>(M3RegistrerActivity.this, R.layout.spinner_item, items_grado);
                        adapter.setDropDownViewResource(R.layout.spinner_item);

                        spinner_grado.setAdapter(adapter);

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    Log.e(TAG, "onThrowable: " + t.toString(), t);
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<GradoEscolar>> call, Throwable t) {

            }
        });
    }

    private int obtenerIDColegio(Spinner spinner) {
        for (int i = 0; i < items_colegio.length; i++) {
            if (items_colegio[i].equals(spinner.getSelectedItem().toString())) {
                return items_colegio_id[i];
            }
        }
        return 0;
    }

    private int obtenerIDGrado(Spinner spinner) {
        for (int i = 0; i < items_grado.length; i++) {
            if (items_grado[i].equals(spinner.getSelectedItem().toString())) {
                return items_grado_id[i];
            }
        }
        return 0;
    }

    private void registrerValidate() {
        camp_01 = edt_camp_01.getText().toString();
        camp_02 = edt_camp_02.getText().toString();
        camp_03 = edt_camp_03.getText().toString();
        camp_04 = edt_camp_04.getText().toString();
        if (camp_01.length() < 1) {
            edt_camp_01.requestFocus();
            Toast.makeText(getApplicationContext(), "Seleccione fecha de inicio", Toast.LENGTH_SHORT).show();
            return;
        } else if (camp_02.length() < 1) {
            edt_camp_02.requestFocus();
            Toast.makeText(getApplicationContext(), "Seleccione fecha de finalización", Toast.LENGTH_SHORT).show();
            return;
        } else if (camp_03.length() < 1) {
            edt_camp_03.requestFocus();
            Toast.makeText(getApplicationContext(), "Ingrese título", Toast.LENGTH_SHORT).show();
            return;
        } else if (camp_04.length() < 1) {
            edt_camp_04.requestFocus();
            Toast.makeText(getApplicationContext(), "Ingrese mensaje", Toast.LENGTH_SHORT).show();
            return;
        }

        insertAnuncio();
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
        LinearLayout layout_02 = alertDialog.findViewById(R.id.ipw_layout_02);
        TextView ipw_title = alertDialog.findViewById(R.id.ipw_title);
        TextView ipw_name = alertDialog.findViewById(R.id.ipw_name);
        TextView ipw_desc = alertDialog.findViewById(R.id.ipw_desc);
        Button ipw_btn_01 = alertDialog.findViewById(R.id.ipw_btn_01);
        Button ipw_btn_02 = alertDialog.findViewById(R.id.ipw_btn_02);

        layout_01.setVisibility(View.GONE);
        layout_02.setVisibility(View.VISIBLE);
        ipw_name.setVisibility(View.INVISIBLE);
        ipw_title.setText(getString(R.string.desc_send_anuncio_success));
        ipw_desc.setText(getString(R.string.desc_question_info));

        ipw_btn_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goM3OptionsActivity();
                alertDialog.dismiss();
            }
        });
        ipw_btn_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                finish();
                startActivity(getIntent());
                clearControllers();
            }
        });
    }

    private void insertAnuncio() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Registrando anuncio...");
        progressDialog.show();

        try {
            reg_date_01 = sdf_reg.parse(currentDate);
            reg_date_02 = sdf_reg.parse(reg_camp_01);
            reg_date_03 = sdf_reg.parse(reg_camp_02);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        reg_camp_03 = camp_03;
        reg_camp_04 = camp_04;

        Colegio colegio = new Colegio();
        colegio.setIdColegio(obtenerIDColegio(spinner_colegio));
        GradoEscolar gradoEscolar = new GradoEscolar();
        gradoEscolar.setIdGrado(obtenerIDGrado(spinner_grado));
        UsuarioSistema usuarioSistema = new UsuarioSistema();
        usuarioSistema.setIdUsusist(user_id);

        Anuncio anuncio = new Anuncio();
        anuncio.setColegioAnuncio(colegio);
        anuncio.setGradoAnuncio(gradoEscolar);
        anuncio.setUsuariosisAnuncio(usuarioSistema);
        //anuncio.setFecRegAnuncio(reg_date_01);
        //anuncio.setFecinAnuncio(reg_date_02);
        //anuncio.setFecfinAnuncio(reg_date_03);
        anuncio.setTitAnuncio(reg_camp_03);
        anuncio.setDescAnuncio(reg_camp_04);
        anuncio.setEstadoAnuncio("1");
        Call<Anuncio> call = service.insertAnuncio(anuncio);
        call.enqueue(new Callback<Anuncio>() {
            @Override
            public void onResponse(Call<Anuncio> call, Response<Anuncio> response) {
                try {
                    int statusCode = response.code();
                    Log.e(TAG, "HTTP status code : " + statusCode);
                    Log.i(TAG, "Response Message : " + response.message());

                    if (response.isSuccessful()) {
                        progressDialog.dismiss();
                        showSuccsessDialog();

                        idAnuncio = response.body().getIdAnuncio();
                        titAnuncio = response.body().getTitAnuncio();
                        descAnuncio = response.body().getDescAnuncio();
                        fecRegAnuncio = response.body().getFecRegAnuncio();
                        fecinAnuncio = response.body().getFecinAnuncio();
                        fecfinAnuncio = response.body().getFecfinAnuncio();
                        estadoAnuncio = response.body().getEstadoAnuncio();
                        colegioAnuncio_id = response.body().getColegioAnuncio().getIdColegio();
                        colegioAnuncio_name = response.body().getColegioAnuncio().getNomColegio();
                        gradoAnuncio_id = response.body().getGradoAnuncio().getIdGrado();
                        gradoAnuncio_desc = response.body().getGradoAnuncio().getDescripcionGradoEscolar() + " " + response.body().getGradoAnuncio().getNivelGradoEscolar();
                        usuariosisAnuncio_id = response.body().getUsuariosisAnuncio().getIdUsusist();
                        usuariosisAnuncio_fullname = user_patname + " " + user_matname + " " + user_name;

                        Log.e(TAG, "ANUNCIO_ID : " + idAnuncio);
                        Log.e(TAG, "ANUNCIO_TITLE : " + titAnuncio);
                        Log.e(TAG, "ANUNCIO_DESC : " + descAnuncio);
                        Log.e(TAG, "ANUNCIO_FEC_REG : " + fecRegAnuncio);
                        Log.e(TAG, "ANUNCIO_FEC_INI : " + fecinAnuncio);
                        Log.e(TAG, "ANUNCIO_FEC_FIN : " + fecfinAnuncio);
                        Log.e(TAG, "ANUNCIO_ESTADO : " + estadoAnuncio);
                        Log.e(TAG, "ANUNCIO_COLEGIO_ID : " + colegioAnuncio_id);
                        Log.e(TAG, "ANUNCIO_COLEGIO_NAME : " + colegioAnuncio_name);
                        Log.e(TAG, "ANUNCIO_GRADO_ID : " + gradoAnuncio_id);
                        Log.e(TAG, "ANUNCIO_GRADO_DESC : " + gradoAnuncio_desc);
                        Log.e(TAG, "ANUNCIO_USUARIO_ID : " + usuariosisAnuncio_id);
                        Log.e(TAG, "ANUNCIO_USUARIO_FULLNAME : " + usuariosisAnuncio_fullname);
                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Error al registrar anuncio.", Toast.LENGTH_LONG).show();
                        Log.e(TAG, "onError: " + response.errorBody().string());
                    }
                } catch (Exception e) {
                    progressDialog.dismiss();
                    Log.e(TAG, "onThrowable: " + e.toString(), e);
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Anuncio> call, Throwable t) {
                progressDialog.dismiss();
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(getApplicationContext(), "Fallo en la conexión.", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void customOrientation() {
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270) {
            layout_main.setPadding(120, 20, 120, 20);
        }
    }

    private void goM3OptionsActivity() {
        startActivity(new Intent(getApplicationContext(), M3OptionsActivity.class)
                .putExtra("USR_ID", user_id)
                .putExtra("USR_TYPE_ID", idTipoUsuSist)
                .putExtra("BASE_URL", base_url_saved)
                .putExtra("ASSISTANT_PHONE", phone_saved)
        );
    }

    @Override
    public void onBackPressed() {
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
            case R.id.am3r_btn_close:
                onBackPressed();
                break;
            case R.id.am3r_btn_registrer:
                registrerValidate();
                break;
        }
    }
}
