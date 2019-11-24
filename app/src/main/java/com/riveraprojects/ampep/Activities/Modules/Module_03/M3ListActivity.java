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
import com.riveraprojects.ampep.Adapters.AdvertismentAdapter;
import com.riveraprojects.ampep.Adapters.AnuncioAdapter;
import com.riveraprojects.ampep.Models.Advertisement;
import com.riveraprojects.ampep.Models.Anuncio;
import com.riveraprojects.ampep.R;
import com.riveraprojects.ampep.Service.ApiService;
import com.riveraprojects.ampep.Service.ApiServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class M3ListActivity extends AppCompatActivity {

    private LinearLayout layout_main;
    private RecyclerView recyclerView;
    private List<Advertisement> advertisementList;

    private static final String TAG = M3ListActivity.class.getSimpleName();

    private SharedPreferences sharedPreferences;
    private String user, pass;
    private int user_id, charge, type, grade;

    private ApiService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m3_list);

        init();
        uploadPreferences();
        uploadSettings();
        //initData();
        //listAnuncios();

        if (type == 4) {
            listAnunciosGrado();
        } else if (type == 5) {
            listAnuncios();
        }
        customOrientation();
    }

    private void uploadSettings() {
        service = ApiServiceGenerator.createService(ApiService.class);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        //recyclerView.setAdapter(new AdvertismentAdapter(this, advertisementList));
        recyclerView.setAdapter(new AnuncioAdapter(this));
    }

    private void init() {
        layout_main = findViewById(R.id.am3l_layout_main);
        recyclerView = findViewById(R.id.am3l_recyclerview);
    }

    private void uploadPreferences() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        user_id = sharedPreferences.getInt("USR_USER_ID", 0);
        user = sharedPreferences.getString("USR_USER", null);
        pass = sharedPreferences.getString("USR_PASS", null);
        charge = sharedPreferences.getInt("CHARGE", 0);
        type = sharedPreferences.getInt("USR_TYPE", 0);
    }

    private void initData() {
        advertisementList = new ArrayList<>();
        advertisementList.add(new Advertisement("ANUNCIO 01", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "20/10/2019"));
        advertisementList.add(new Advertisement("ANUNCIO 02", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "22/10/2019"));
        advertisementList.add(new Advertisement("ANUNCIO 03", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "24/10/2019"));
        advertisementList.add(new Advertisement("ANUNCIO 04", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "26/10/2019"));

        advertisementList.add(new Advertisement("ANUNCIO 05", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "20/10/2019"));
        advertisementList.add(new Advertisement("ANUNCIO 06", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "22/10/2019"));
        advertisementList.add(new Advertisement("ANUNCIO 07", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "24/10/2019"));
        advertisementList.add(new Advertisement("ANUNCIO 08", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "26/10/2019"));

        advertisementList.add(new Advertisement("ANUNCIO 10", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "20/10/2019"));
        advertisementList.add(new Advertisement("ANUNCIO 11", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "22/10/2019"));
        advertisementList.add(new Advertisement("ANUNCIO 12", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "24/10/2019"));
        /*advertisementList.add(new Advertisement("ANUNCIO 13", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "26/10/2019"));

        advertisementList.add(new Advertisement("ANUNCIO 14", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "20/10/2019"));
        advertisementList.add(new Advertisement("ANUNCIO 15", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "22/10/2019"));
        advertisementList.add(new Advertisement("ANUNCIO 16", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "24/10/2019"));
        advertisementList.add(new Advertisement("ANUNCIO 17", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "26/10/2019"));

        advertisementList.add(new Advertisement("ANUNCIO 18", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "20/10/2019"));
        advertisementList.add(new Advertisement("ANUNCIO 19", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "22/10/2019"));
        advertisementList.add(new Advertisement("ANUNCIO 20", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "24/10/2019"));
        advertisementList.add(new Advertisement("ANUNCIO 21", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "26/10/2019"));

        advertisementList.add(new Advertisement("ANUNCIO 22", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "20/10/2019"));
        advertisementList.add(new Advertisement("ANUNCIO 23", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "22/10/2019"));
        advertisementList.add(new Advertisement("ANUNCIO 24", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "24/10/2019"));
        advertisementList.add(new Advertisement("ANUNCIO 25", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "26/10/2019"));

        advertisementList.add(new Advertisement("ANUNCIO 26", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "20/10/2019"));
        advertisementList.add(new Advertisement("ANUNCIO 27", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "22/10/2019"));
        advertisementList.add(new Advertisement("ANUNCIO 28", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "24/10/2019"));
        advertisementList.add(new Advertisement("ANUNCIO 29", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "26/10/2019"));*/
    }

    private void customOrientation() {
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270) {
            layout_main.setPadding(120, 20, 120, 20);
        }
    }

    private void goModulesAreaActivity() {
        startActivity(new Intent(getApplicationContext(), ModulesAreaActivity.class)
                .putExtra("SEND_CODE", "CODE_M3LA"));
    }

    private void goM3OptionsActivity() {
        startActivity(new Intent(getApplicationContext(), M3OptionsActivity.class)
                .putExtra("SEND_CODE", "CODE_M3LA"));
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
        if (type == 4) {
            goModulesAreaActivity();
        } else if (type == 5) {
            goM3OptionsActivity();
        }
    }
}
