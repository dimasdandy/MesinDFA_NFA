package com.example.mesinabstrak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class dfa_tuple extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dfa_tuple);
    }

    @Override
    public void onBackPressed() {
        Intent awal = new Intent(dfa_tuple.this, dfa.class);
        startActivity(awal);
        finish();
        super.onBackPressed();
    }
}
