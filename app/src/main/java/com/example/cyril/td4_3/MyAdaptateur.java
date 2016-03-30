package com.example.cyril.td4_3;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Cyril on 29/02/2016.
 */
public class MyAdaptateur extends ArrayAdapter<Tache> {
    private Context context;
    private int ressource;
    private List<Tache> objects;

    public MyAdaptateur(Context context, int ressource, List<Tache> objects) {
        super(context, ressource, objects);
        this.context = context;
        this.ressource = ressource;
        this.objects = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.task_list, parent, false);
        TextView textView1 = (TextView) view.findViewById(R.id.name_task);
        TextView textView2 = (TextView) view.findViewById(R.id.priorite);
        textView1.setText(objects.get(position).get_titre());
        textView2.setText(objects.get(position).get_priorite());
        if(objects.get(position).get_etat()) {
            view.setBackgroundColor(Color.WHITE);
        }else {
            view.setBackgroundColor(Color.GRAY);
        }
        return view;
    }
}
