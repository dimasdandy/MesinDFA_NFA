package com.example.mesinabstrak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class dfa extends AppCompatActivity {

    ImageView machine, tuple;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dfa);
    }

    @Override
    public void onBackPressed() {
        Intent awal = new Intent(dfa.this, MenuAct.class);
        startActivity(awal);
        finish();
        super.onBackPressed();
    }

    public void machine(View view) {
        machine = findViewById(R.id.machine);
        Intent awal = new Intent(dfa.this, dfa_proses.class);
        startActivity(awal);
        finish();
    }

    public void tuple(View view) {
        tuple = findViewById(R.id.tuple);
        Intent awal = new Intent(dfa.this, dfa_tuple.class);
        startActivity(awal);
        finish();
    }

}
