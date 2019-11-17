package com.riveraprojects.ampep.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.riveraprojects.ampep.Models.Advertisement;
import com.riveraprojects.ampep.R;

import java.util.List;

public class AdvertismentAdapter extends RecyclerView.Adapter<AdvertismentAdapter.ViewHolder> {

    private Activity activity;
    private List<Advertisement> advertisementList;

    private static final String TAG = AdvertismentAdapter.class.getSimpleName();

    public AdvertismentAdapter(Activity activity, List<Advertisement> advertisementList) {
        this.activity = activity;
        this.advertisementList = advertisementList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, desc, teacher, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.ia_title);
            desc = itemView.findViewById(R.id.ia_desc);
            teacher = itemView.findViewById(R.id.ia_teacher);
            date = itemView.findViewById(R.id.ia_date);
        }
    }

    @NonNull
    @Override
    public AdvertismentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_advertisement, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdvertismentAdapter.ViewHolder holder, int position) {
        Advertisement advertisement = advertisementList.get(position);
        holder.title.setText(advertisement.getTitle());
        holder.desc.setText(advertisement.getDesc());
        holder.teacher.setText(advertisement.getTeacher());
        holder.date.setText(advertisement.getDate());
    }

    @Override
    public int getItemCount() {
        return advertisementList.size();
    }
}
