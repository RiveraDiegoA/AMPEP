package com.riveraprojects.ampep.Adapters;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.riveraprojects.ampep.Models.Anuncio;
import com.riveraprojects.ampep.R;

import java.util.ArrayList;
import java.util.List;

public class AnuncioAdapter extends RecyclerView.Adapter<AnuncioAdapter.ViewHolder> {

    private Activity activity;
    private List<Anuncio> anuncioList;

    private SharedPreferences sharedPreferences;
    private String user, grade;

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

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
        user = sharedPreferences.getString("USR_USER", null);

        if (user.equalsIgnoreCase("drivera_usr")) {
            grade = "Primaria";
        } else if (user.equalsIgnoreCase("drivera_usr_2")) {
            grade = "Secundaria";
        }

        Anuncio anuncio = anuncioList.get(position);
        holder.title.setText(anuncio.getTitulo());
        holder.desc.setText(anuncio.getDescrip());
        holder.school.setText(anuncio.getColegioAnuncio().getNomColegio());
        //holder.grade.setText(anuncio.getGradoColegioAnuncio().getIdGrado());
        holder.grade.setText(grade);
        holder.teacher.setText(anuncio.getUsuarioAnuncio().getUsuario());
        holder.date.setText(anuncio.getFechRegis().toString());

        //holder.cardView.setAnimation(AnimationUtils.loadAnimation(activity, R.anim.fade_scale));
        holder.title.setAnimation(AnimationUtils.loadAnimation(activity, R.anim.fade_scale));
        holder.desc.setAnimation(AnimationUtils.loadAnimation(activity, R.anim.fade_scale));
        holder.school.setAnimation(AnimationUtils.loadAnimation(activity, R.anim.fade_scale));
        holder.grade.setAnimation(AnimationUtils.loadAnimation(activity, R.anim.fade_scale));
        holder.teacher.setAnimation(AnimationUtils.loadAnimation(activity, R.anim.fade_scale));
        holder.date.setAnimation(AnimationUtils.loadAnimation(activity, R.anim.fade_scale));
    }

    @Override
    public int getItemCount() {
        return anuncioList.size();
    }
}
