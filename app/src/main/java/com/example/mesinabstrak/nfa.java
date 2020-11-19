package com.example.mesinabstrak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class nfa extends AppCompatActivity {

    ImageView tuple2, machine2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfa);
    }

    @Override
    public void onBackPressed() {
        Intent awal = new Intent(nfa.this, MenuAct.class);
        startActivity(awal);
        finish();
        super.onBackPressed();
    }

    public void tuple2(View view) {
        tuple2 = findViewById(R.id.tuple2);
        Intent awal = new Intent(nfa.this, nfa_tuple.class);
        startActivity(awal);
        finish();
    }

    public void machine2(View view) {
        machine2 = findViewById(R.id.machine2);
        Intent awal = new Intent(nfa.this, nfa_proses.class);
        startActivity(awal);
        finish();
    }
}
