package com.riveraprojects.ampep.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.riveraprojects.ampep.Models.UsuarioSistema;
import com.riveraprojects.ampep.R;

import java.util.ArrayList;
import java.util.List;

public class UsuarioSistemaAdapter extends RecyclerView.Adapter<UsuarioSistemaAdapter.ViewHolder> {

    private Activity activity;
    private List<UsuarioSistema> usuarioSistemaList;

    public UsuarioSistemaAdapter(Activity activity) {
        this.activity = activity;
        this.usuarioSistemaList = new ArrayList<>();
    }

    public void setUsuarioSistema(List<UsuarioSistema> usuarioSistema) {
        this.usuarioSistemaList = usuarioSistema;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView camp_01, camp_02, camp_03, camp_04;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            camp_01 = itemView.findViewById(R.id.ius_camp_01);
            camp_02 = itemView.findViewById(R.id.ius_camp_02);
            camp_03 = itemView.findViewById(R.id.ius_camp_03);
            camp_04 = itemView.findViewById(R.id.ius_camp_04);
        }
    }

    @NonNull
    @Override
    public UsuarioSistemaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario_sistema, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UsuarioSistema usuarioSistema = usuarioSistemaList.get(position);

        holder.camp_01.setText(usuarioSistema.getIdUsusist() + "");
        holder.camp_02.setText(usuarioSistema.getUsuario());
        holder.camp_03.setText(usuarioSistema.getContrasen());
        holder.camp_04.setText(usuarioSistema.getIdTipoUsuSist().getDescripci());
    }

    @Override
    public int getItemCount() {
        return usuarioSistemaList.size();
    }
}
