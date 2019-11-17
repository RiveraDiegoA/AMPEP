package com.riveraprojects.ampep.Activities.Modules.Module_03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Surface;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.riveraprojects.ampep.Activities.ModulesAreaActivity;
import com.riveraprojects.ampep.Adapters.AdvertismentAdapter;
import com.riveraprojects.ampep.Models.Advertisement;
import com.riveraprojects.ampep.R;

import java.util.ArrayList;
import java.util.List;

public class M3ListActivity extends AppCompatActivity {

    private LinearLayout layout_main;
    private RecyclerView recyclerView;
    private List<Advertisement> advertisementList;

    private static final String TAG = M3ListActivity.class.getSimpleName();

    private SharedPreferences sharedPreferences;
    private String user, pass;
    private int charge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m3_list);

        init();
        uploadPreferences();
        initData();
        customOrientation();

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new AdvertismentAdapter(this, advertisementList));
    }

    private void init() {
        layout_main = findViewById(R.id.am3l_layout_main);
        recyclerView = findViewById(R.id.am3l_recyclerview);
    }

    private void uploadPreferences() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        user = sharedPreferences.getString("USER", null);
        pass = sharedPreferences.getString("PASS", null);
        charge = sharedPreferences.getInt("CHARGE", 0);
    }

    private void initData() {
        advertisementList = new ArrayList<>();
        advertisementList.add(new Advertisement("ANUNCIO 01", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "20/10/2019"));
        advertisementList.add(new Advertisement("ANUNCIO 02", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "22/10/2019"));
        advertisementList.add(new Advertisement("ANUNCIO 03", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "24/10/2019"));
        advertisementList.add(new Advertisement("ANUNCIO 04", getString(R.string.text_desc), "Rivera Ambrosio Jean Diego", "26/10/2019"));
    }

    private void customOrientation() {
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270) {
            layout_main.setPadding(120, 20, 120, 20);
        }
    }

    private void goModulesAreaActivity() {
        startActivity(new Intent(getApplicationContext(), ModulesAreaActivity.class));
    }

    private void goM3OptionsActivity() {
        startActivity(new Intent(getApplicationContext(), M3OptionsActivity.class));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (charge == 1) {
            goModulesAreaActivity();
        } else if (charge == 2) {
            goM3OptionsActivity();
        }
    }
}
