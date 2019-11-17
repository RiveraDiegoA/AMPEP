package com.riveraprojects.ampep.Activities.Test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.riveraprojects.ampep.Adapters.PersonAdapter;
import com.riveraprojects.ampep.Models.Person;
import com.riveraprojects.ampep.R;
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

    private static String TAG = TestActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        init();
        uploadSettigs();
    }

    private void uploadSettigs() {
        personService = Apis.getPersonService();
    }

    private void init() {
        listView = findViewById(R.id.at_listview);
        button = findViewById(R.id.at_btn);
        button.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.at_btn:
                listPersons();
                break;
        }
    }
}
