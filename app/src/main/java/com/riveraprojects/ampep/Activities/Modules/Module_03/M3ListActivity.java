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
