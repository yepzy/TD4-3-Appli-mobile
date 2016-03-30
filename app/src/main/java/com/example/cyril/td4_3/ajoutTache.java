package com.example.cyril.td4_3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class ajoutTache extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_tache);

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        ArrayAdapter<Integer> adapt = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, list);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setAdapter(adapt);
        ((Button) findViewById(R.id.valide)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        setResult(RESULT_OK, new Intent()
                .putExtra("titre", ((EditText) findViewById(R.id.editText)).getText().toString())
                .putExtra("priorite", ((Spinner) findViewById(R.id.spinner)).getSelectedItem().toString())
            );
        Log.e("yoloooooooooo", ((Spinner) findViewById(R.id.spinner)).getSelectedItem().toString());
        finish();
    }
}
