package com.example.mesinabstrak;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView applogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        applogo = findViewById(R.id.applogo);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //menuju halaman lain

                Intent awal = new Intent(MainActivity.this, MenuAct.class);
                startActivity(awal);
                finish();
            }
        }, 2000);
    }
}
