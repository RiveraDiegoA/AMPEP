package com.riveraprojects.ampep.Activities.Modules.Module_03;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Surface;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.riveraprojects.ampep.Activities.ModulesAreaActivity;
import com.riveraprojects.ampep.Adapters.AnuncioAdapter;
import com.riveraprojects.ampep.Models.Advertisement;
import com.riveraprojects.ampep.Models.Anuncio;
import com.riveraprojects.ampep.R;
import com.riveraprojects.ampep.Service.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class M3ListActivity extends AppCompatActivity {

    private LinearLayout layout_main;
    private RecyclerView recyclerView;
    private List<Advertisement> advertisementList;

    private static final String TAG = M3ListActivity.class.getSimpleName();

    private String base_url_saved, phone_saved, user, pass;
    private int user_id, grade, idUsusist, idTipoUsuSist;

    private ApiService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m3_list);

        init();
        getIntentData();
        //initData();
        //listAnuncios();

        /*if (type == 4) {
            listAnunciosGrado();
        } else if (type == 5) {
            listAnuncios();
        }*/
        listAnuncios();
        customOrientation();
    }

    private void init() {
        layout_main = findViewById(R.id.am3l_layout_main);
        recyclerView = findViewById(R.id.am3l_recyclerview);
    }

    private void getIntentData() {
        Intent intent = getIntent();
        idUsusist = intent.getIntExtra("USR_ID", 0);
        idTipoUsuSist = intent.getIntExtra("USR_TYPE_ID", 0);
        base_url_saved = intent.getStringExtra("BASE_URL");
        phone_saved = intent.getStringExtra("ASSISTANT_PHONE");
        Log.d(TAG, "ASSISTANT_PHONE: " + phone_saved);
        Log.d(TAG, "URL_BASE: " + base_url_saved);

        uploadSettings(base_url_saved);
    }

    private void uploadSettings(String base_url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiService.class);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new AnuncioAdapter(this));
    }

    private void customOrientation() {
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270) {
            layout_main.setPadding(120, 20, 120, 20);
        }
    }

    private void goModulesAreaActivity() {
        startActivity(new Intent(getApplicationContext(), ModulesAreaActivity.class)
                .putExtra("USR_ID", user_id)
                .putExtra("SEND_CODE", "CODE_M3LA")
                .putExtra("BASE_URL", base_url_saved)
                .putExtra("ASSISTANT_PHONE", phone_saved)
                .putExtra("USR_TYPE_ID", idTipoUsuSist)
        );
    }

    private void goM3OptionsActivity() {
        startActivity(new Intent(getApplicationContext(), M3OptionsActivity.class)
                .putExtra("SEND_CODE", "CODE_M3LA")
                .putExtra("USR_ID", user_id)
                .putExtra("BASE_URL", base_url_saved)
                .putExtra("ASSISTANT_PHONE", phone_saved)
                .putExtra("USR_TYPE_ID", idTipoUsuSist)
        );
    }

    public void listAnuncios() {
        Call<List<Anuncio>> call = service.getAnuncios();
        call.enqueue(new Callback<List<Anuncio>>() {
            @Override
            public void onResponse(Call<List<Anuncio>> call, Response<List<Anuncio>> response) {
                try {
                    int statusCode = response.code();
                    Log.e(TAG, "HTTP status code : " + statusCode);
                    Log.i(TAG, "Response Message : " + response.message());

                    if (response.isSuccessful()) {
                        List<Anuncio> anuncio = response.body();

                        String text = "";
                        int size = anuncio.size();

                        if (size < 0) {
                            text = "AÚN NO SE HAN REGISTRADO ANUNCIOS";
                        } else if (size == 1) {
                            text = " ANUNCIO REGISTRADO";
                        } else {
                            text = " ANUNCIOS REGISTRADOS";
                        }

                        Log.i(TAG, "USUARIO SISTEMA SIZE : " + size);
                        Toast.makeText(getApplicationContext(), size + text, Toast.LENGTH_LONG).show();
                        //textView.setText(size + text);

                        AnuncioAdapter adapter = (AnuncioAdapter) recyclerView.getAdapter();
                        adapter.setAnuncio(anuncio);
                        adapter.notifyDataSetChanged();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    Log.e(TAG, "onThrowable: " + e.toString(), e);
                }
            }

            @Override
            public void onFailure(Call<List<Anuncio>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void listAnunciosGrado() {
        if (user.equalsIgnoreCase("drivera_usr")) {
            grade = 1;
        } else if (user.equalsIgnoreCase("drivera_usr_2")) {
            grade = 2;
        }
        Call<List<Anuncio>> call = service.getAnunciosxGrado(grade);
        call.enqueue(new Callback<List<Anuncio>>() {
            @Override
            public void onResponse(Call<List<Anuncio>> call, Response<List<Anuncio>> response) {
                try {
                    int statusCode = response.code();
                    Log.e(TAG, "HTTP status code : " + statusCode);
                    Log.i(TAG, "Response Message : " + response.message());

                    if (response.isSuccessful()) {
                        List<Anuncio> anuncio = response.body();

                        String text = "";
                        int size = anuncio.size();

                        if (size < 0) {
                            text = "AÚN NO SE HAN REGISTRADO ANUNCIOS";
                        } else if (size == 1) {
                            text = " ANUNCIO REGISTRADO";
                        } else {
                            text = " ANUNCIOS REGISTRADOS";
                        }

                        Log.i(TAG, "USUARIO SISTEMA SIZE : " + size);
                        Toast.makeText(getApplicationContext(), size + text, Toast.LENGTH_LONG).show();
                        //textView.setText(size + text);

                        AnuncioAdapter adapter = (AnuncioAdapter) recyclerView.getAdapter();
                        adapter.setAnuncio(anuncio);
                        adapter.notifyDataSetChanged();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    Log.e(TAG, "onThrowable: " + e.toString(), e);
                }
            }

            @Override
            public void onFailure(Call<List<Anuncio>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void listAnunciosUsuario() {

        Toast.makeText(this, "" + user_id, Toast.LENGTH_LONG).show();

        Call<List<Anuncio>> call = service.getAnunciosxUsuarioSist(3);
        call.enqueue(new Callback<List<Anuncio>>() {
            @Override
            public void onResponse(Call<List<Anuncio>> call, Response<List<Anuncio>> response) {
                try {
                    int statusCode = response.code();
                    Log.e(TAG, "HTTP status code : " + statusCode);
                    Log.i(TAG, "Response Message : " + response.message());

                    if (response.isSuccessful()) {
                        List<Anuncio> anuncio = response.body();

                        String text = "";
                        int size = anuncio.size();

                        if (size < 0) {
                            text = "AÚN NO SE HAN REGISTRADO ANUNCIOS";
                        } else if (size == 1) {
                            text = " ANUNCIO REGISTRADO";
                        } else {
                            text = " ANUNCIOS REGISTRADOS";
                        }

                        Log.i(TAG, "USUARIO SISTEMA SIZE : " + size);
                        Toast.makeText(getApplicationContext(), size + text, Toast.LENGTH_LONG).show();
                        //textView.setText(size + text);

                        AnuncioAdapter adapter = (AnuncioAdapter) recyclerView.getAdapter();
                        adapter.setAnuncio(anuncio);
                        adapter.notifyDataSetChanged();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    Log.e(TAG, "onThrowable: " + e.toString(), e);
                }
            }

            @Override
            public void onFailure(Call<List<Anuncio>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (idTipoUsuSist == 4) {
            goModulesAreaActivity();
        } else if (idTipoUsuSist == 5) {
            goM3OptionsActivity();
        }
    }
}
