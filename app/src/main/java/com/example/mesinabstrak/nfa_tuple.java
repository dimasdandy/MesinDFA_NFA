package com.example.mesinabstrak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class nfa_tuple extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfa_tuple);
    }

    @Override
    public void onBackPressed() {
        Intent awal = new Intent(nfa_tuple.this, nfa.class);
        startActivity(awal);
        finish();
        super.onBackPressed();
    }
}
