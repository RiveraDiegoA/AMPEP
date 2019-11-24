package com.riveraprojects.ampep.Activities.Test;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.riveraprojects.ampep.Adapters.PersonAdapter;
import com.riveraprojects.ampep.Adapters.UsuarioSistemaAdapter;
import com.riveraprojects.ampep.Models.Person;
import com.riveraprojects.ampep.Models.UsuarioSistema;
import com.riveraprojects.ampep.R;
import com.riveraprojects.ampep.Service.ApiService;
import com.riveraprojects.ampep.Service.ApiServiceGenerator;
import com.riveraprojects.ampep.Utils.Apis;
import com.riveraprojects.ampep.Utils.PersonService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView listView;
    private Button button;

    private PersonService personService;
    private List<Person> personList = new ArrayList<>();

    private ApiService service;
    private RecyclerView recyclerView;
    private TextView textView;

    private static String TAG = TestActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        init();
        uploadSettigs();
    }

    private void init() {
        listView = findViewById(R.id.at_listview);
        recyclerView = findViewById(R.id.at_recyclerview);
        textView = findViewById(R.id.at_text);
        button = findViewById(R.id.at_btn);
        button.setOnClickListener(this);
    }

    private void uploadSettigs() {
        personService = Apis.getPersonService();
        service = ApiServiceGenerator.createService(ApiService.class);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new UsuarioSistemaAdapter(this));
    }

    public void listPersons() {
        Call<List<Person>> call = personService.getPersons();
        call.enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                if (response.isSuccessful()) {
                    personList = response.body();
                    listView.setAdapter(new PersonAdapter(TestActivity.this, R.layout.item_list, personList));
                } else {
                    Toast.makeText(TestActivity.this, "ERROR AL OBTENER DATOS", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {
                Toast.makeText(TestActivity.this, "ERROR EN LA CONEXIÓN", Toast.LENGTH_SHORT).show();
                Log.e(TAG, t.getMessage());
            }
        });
    }

    public void listUsuariosSistema() {
        Call<List<UsuarioSistema>> call = service.getUsuariosSistema();
        call.enqueue(new Callback<List<UsuarioSistema>>() {
            @Override
            public void onResponse(Call<List<UsuarioSistema>> call, Response<List<UsuarioSistema>> response) {
                try {
                    int statusCode = response.code();
                    Log.e(TAG, "HTTP status code : " + statusCode);
                    Log.i(TAG, "Response Message : " + response.message());

                    if (response.isSuccessful()) {
                        List<UsuarioSistema> usuarioSistema = response.body();

                        String text = "";
                        int size = usuarioSistema.size();

                        if (usuarioSistema.size() < 0) {
                            text = "AÚN NO SE HAN REGISTRADO USUARIOS";
                        } else if (usuarioSistema.size() == 1) {
                            text = " USUARIO REGISTRADO";
                        } else {
                            text = " USUARIOS REGISTRADOS";
                        }

                        Log.i(TAG, "USUARIO SISTEMA SIZE : " + size);
                        //Toast.makeText(getApplicationContext(), size + text, Toast.LENGTH_LONG).show();
                        textView.setText(size + text);

                        UsuarioSistemaAdapter adapter = (UsuarioSistemaAdapter) recyclerView.getAdapter();
                        adapter.setUsuarioSistema(usuarioSistema);
                        adapter.notifyDataSetChanged();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    Log.e(TAG, "onThrowable: " + e.toString(), e);
                }
            }

            @Override
            public void onFailure(Call<List<UsuarioSistema>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.at_btn:
                listUsuariosSistema();
                break;
        }
    }
}
