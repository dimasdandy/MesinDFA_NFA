package com.example.mesinabstrak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class aboutus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
    }

    @Override
    public void onBackPressed() {
        Intent awal = new Intent(aboutus.this, MenuAct.class);
        startActivity(awal);
        finish();
        super.onBackPressed();
    }
}
