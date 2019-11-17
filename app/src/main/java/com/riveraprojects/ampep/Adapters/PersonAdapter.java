package com.riveraprojects.ampep.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.riveraprojects.ampep.Models.Person;
import com.riveraprojects.ampep.R;

import java.util.List;

public class PersonAdapter extends ArrayAdapter<Person> {

    private Activity activity;
    private List<Person> personList;

    public PersonAdapter(@NonNull Activity activity, int resource, @NonNull List<Person> objects) {
        super(activity, resource, objects);
        this.activity = activity;
        this.personList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = layoutInflater.inflate(R.layout.item_list, parent, false);

        TextView txt_id = rowView.findViewById(R.id.il_id);
        TextView txt_name = rowView.findViewById(R.id.il_name);
        TextView txt_lastane = rowView.findViewById(R.id.il_lastname);

        Person person = personList.get(position);

        txt_id.setText(String.format("ID:%s", person.getId()));
        txt_name.setText(String.format("NOMBRE:%s", person.getName()));
        txt_lastane.setText(String.format("APELLIDO:%s", person.getLastname()));

        return rowView;
    }
}
