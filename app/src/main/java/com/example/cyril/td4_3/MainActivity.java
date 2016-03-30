package com.example.cyril.td4_3;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener,ListView.OnItemLongClickListener {

    public int REQUEST_CODE = 88;
    public MyAdaptateur adapt;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView  = (ListView) findViewById(R.id.task_list);
        List<Tache> list = new ArrayList<Tache>();
        list.add(new Tache("first task",1,true));
        list.add(new Tache("second task",2,true));
        adapt = new MyAdaptateur(this,R.layout.task_list,list);
        listView.setAdapter(adapt);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
    }


    public void addTask(View v) {
        Intent toTheNext = new Intent(MainActivity.this, ajoutTache.class);
        startActivityForResult(toTheNext, REQUEST_CODE);
    }

    public void delTask(View v){
        for(int i=0; i< adapt.getCount();i++){
            Tache cur = adapt.getItem(i);
            if(!cur.get_etat()) {
                adapt.remove(cur);
            }
        }
        listView.invalidateViews();
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            Bundle bund = data.getExtras();
            if(bund != null){
                String titre = bund.getString("titre");
                String priorite = bund.getString("priorite");
                if(titre != null){
                    adapt.add(new Tache(titre,Integer.valueOf(priorite),true));

                }
            }
    }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        adapt.getItem(position).set_etat(false);
        listView.getChildAt(position).setBackgroundColor(Color.GRAY);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        adapt.remove(adapt.getItem(position));
        listView.invalidateViews();
        Log.i("test", "long");
        return true;
    }
}
