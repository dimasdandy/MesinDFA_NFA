package com.example.mesinabstrak;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuAct extends AppCompatActivity {

    ImageView dfa, aboutus,nfa, imageView3;
    Animation atg, atg2;
    TextView pagetitle, pagesubtitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        atg = AnimationUtils.loadAnimation(this,R.anim.atg);
        atg2 = AnimationUtils.loadAnimation(this,R.anim.atg2);

        imageView3 = findViewById(R.id.imageView3);
        pagetitle = findViewById(R.id.pagetitle);
        pagesubtitle = findViewById(R.id.pagesubtitle);

        imageView3.startAnimation(atg);
        pagetitle.startAnimation(atg2);
        pagesubtitle.startAnimation(atg2);
    }

    public void dfa(View view) {
        dfa = findViewById(R.id.dfa);
        Intent awal = new Intent(MenuAct.this, dfa.class);
        startActivity(awal);
        finish();
    }
    public void nfa(View view) {
        nfa = findViewById(R.id.nfa);
        Intent awal = new Intent(MenuAct.this, nfa.class);
        startActivity(awal);
        finish();
    }
    public void aboutus(View view) {
        aboutus = findViewById(R.id.aboutus);
        Intent awal = new Intent(MenuAct.this, aboutus.class);
        startActivity(awal);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
