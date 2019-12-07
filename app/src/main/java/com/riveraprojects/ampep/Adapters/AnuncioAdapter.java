package com.riveraprojects.ampep.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.riveraprojects.ampep.Activities.Modules.Module_03.M3ListActivity;
import com.riveraprojects.ampep.Models.Anuncio;
import com.riveraprojects.ampep.Models.Profesor;
import com.riveraprojects.ampep.R;
import com.riveraprojects.ampep.Service.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnuncioAdapter extends RecyclerView.Adapter<AnuncioAdapter.ViewHolder> {

    private Activity activity;
    private List<Anuncio> anuncioList;

    private String base_url_saved, phone_saved;
    private int idProfeso, idTipoUsuSist;
    private String apePatern, apeMatern, nombres, fullname;

    private ApiService service;

    private static String TAG = M3ListActivity.class.getSimpleName();

    public AnuncioAdapter(Activity activity) {
        this.activity = activity;
        this.anuncioList = new ArrayList<>();
    }

    public void setAnuncio(List<Anuncio> anuncio) {
        this.anuncioList = anuncio;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private TextView title, desc, school, grade, teacher, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.ia_cardview);
            title = itemView.findViewById(R.id.ia_title);
            desc = itemView.findViewById(R.id.ia_desc);
            school = itemView.findViewById(R.id.ia_school);
            grade = itemView.findViewById(R.id.ia_grade);
            teacher = itemView.findViewById(R.id.ia_teacher);
            date = itemView.findViewById(R.id.ia_date);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_advertisement, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Anuncio anuncio = anuncioList.get(position);
        holder.title.setText(anuncio.getTitAnuncio());
        holder.desc.setText(anuncio.getDescAnuncio());
        holder.school.setText(anuncio.getColegioAnuncio().getNomColegio());
        holder.grade.setText(anuncio.getGradoAnuncio().getDescripcionGradoEscolar() + " " + anuncio.getGradoAnuncio().getNivelGradoEscolar());
        holder.date.setText(String.valueOf(anuncio.getFecRegAnuncio()));


        getIntentData();
        int idPersona = anuncio.getUsuariosisAnuncio().getIdPersona();
        getProfedorById(idPersona, holder);

        //holder.teacher.setText(fullname);

        holder.title.setAnimation(AnimationUtils.loadAnimation(activity, R.anim.fade_scale));
        holder.desc.setAnimation(AnimationUtils.loadAnimation(activity, R.anim.fade_scale));
        holder.school.setAnimation(AnimationUtils.loadAnimation(activity, R.anim.fade_scale));
        holder.grade.setAnimation(AnimationUtils.loadAnimation(activity, R.anim.fade_scale));
        holder.teacher.setAnimation(AnimationUtils.loadAnimation(activity, R.anim.fade_scale));
        holder.date.setAnimation(AnimationUtils.loadAnimation(activity, R.anim.fade_scale));
    }

    /*private void uploadPreferences() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
        sp_base_url_saved = sharedPreferences.getString("BASE_URL", null);
    }*/

    private void getIntentData() {
        Intent intent = activity.getIntent();
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
    }

    private void getProfedorById(int idPersona, final ViewHolder holder) {
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

                        fullname = apePatern + " " + apeMatern + " " + nombres;
                        holder.teacher.setText(fullname);

                        Log.e(TAG, "USER FULL NAME : " + apePatern + " " + apeMatern + " " + nombres);
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

    @Override
    public int getItemCount() {
        return anuncioList.size();
    }
}
