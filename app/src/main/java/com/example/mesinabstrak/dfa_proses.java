package com.example.mesinabstrak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class dfa_proses extends AppCompatActivity {

    Button btnConvert, btnOutput, btnReset;
    RadioButton rdDesimal, rdOctal, rdHexa;
    RadioGroup rgPilih;
    EditText etInput, etOuput;
    TextView viewOut;
    String hasil = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dfa_proses);
        etOuput = findViewById(R.id.etOutput);
        etInput = findViewById(R.id.etInput);
        viewOut = findViewById(R.id.viewOut);
        rgPilih = findViewById(R.id.rgPilih);
        rdDesimal = findViewById(R.id.rdDesimal);
        rdHexa = findViewById(R.id.rdHexa);
        rdOctal = findViewById(R.id.rdOctal);
        btnConvert = findViewById(R.id.btnConvert);
        btnOutput = findViewById(R.id.btnOutput);
        btnReset = findViewById(R.id.btnReset);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id_pilih = rgPilih.getCheckedRadioButtonId();
                String txtangka = etInput.getText().toString();

                int length_angka = txtangka.length();
                String saveAR[] = new String[5];

                next:
                if (id_pilih == R.id.rdDesimal) {
                    int angkaint = Integer.parseInt(txtangka);
                    if (angkaint > 255){
                        Toast.makeText(getApplicationContext(), "Maksimal angka yang di input adalah 255.", Toast.LENGTH_SHORT).show();
                        break next;
                    }
                    klikBiner(txtangka);
                } else if (id_pilih == R.id.rdOctal) {
                    for (int i = 0; i < length_angka; i++){
                        saveAR[i] = txtangka.substring(i, i + 1);
                        int intsave = Integer.parseInt(saveAR[i]);
                        if (intsave > 7){
                            Toast.makeText(getApplicationContext(), "Input angka 0 sampai 7.", Toast.LENGTH_SHORT).show();
                            break next;
                        }
                    }
                    if (length_angka > 2){
                        Toast.makeText(getApplicationContext(), "Maksimal jumlah angka yang di input adalah 2 digit.", Toast.LENGTH_SHORT).show();
                        break next;
                    }
                    klikoctal(txtangka);
                } else if (id_pilih == R.id.rdHexa) {
                    if (length_angka > 2){
                        Toast.makeText(getApplicationContext(), "Maksimal jumlah angka yang di input adalah 2 digit.", Toast.LENGTH_SHORT).show();
                        break next;
                    }
                    klikhexa(txtangka);
                }
            }
        });

        btnOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtangka = etOuput.getText().toString();
                fungsi(txtangka);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etOuput.setText("0");
                etInput.setText("0");
                viewOut.setText("");
            }
        });
    }

    public void btnConvert(View view) {
        int id_pilih = rgPilih.getCheckedRadioButtonId();
        String txtangka = etInput.getText().toString();
        int angkaint = Integer.parseInt(txtangka);


        if (id_pilih == R.id.rdDesimal) {
            klikBiner(txtangka);
        } else if (id_pilih == R.id.rdOctal) {
            klikoctal(txtangka);
        } else if (id_pilih == R.id.rdHexa) {
            klikhexa(txtangka);
        }
    }
    public void btnoutput(View view) {
        String txtangka = etOuput.getText().toString();
        fungsi(txtangka);
    }

    public void klikBiner(String txtangka) {
        //String txtangka = txtDecimal.getText().toString();
        int i = Integer.parseInt(txtangka);
        String hasil = Integer.toBinaryString(i);
        int length_hasil = hasil.length();

        for (int a = 0; a < 8 - length_hasil; a++) {
            hasil = "0" + hasil;
        }
        etOuput.setText(hasil);
    }

    public void klikoctal(String txtangka) {
        int i = Integer.parseInt(txtangka, 8);
        String outangka = Integer.toBinaryString(i);

        int length_angka = txtangka.length();
        int length_out = outangka.length();

        if (length_angka == 1) {
            if (length_out == 1) {
                outangka = "00" + outangka;
            } else if (length_out == 2) {
                outangka = "0" + outangka;
            }
        } else if (length_angka == 2) {
            if (length_out == 4) {
                outangka = "00" + outangka;
            } else if (length_out == 5) {
                outangka = "0" + outangka;
            }
        }
        etOuput.setText(outangka);
    }

    public void klikhexa(String txtangka) {
        int i = Integer.parseInt(txtangka, 16);
        String outangka = Integer.toBinaryString(i);

        int length_angka = txtangka.length();
        int length_out = outangka.length();

        if (length_angka == 1) {
            if (length_out == 1) {
                outangka = "000" + outangka;
            } else if (length_out == 2) {
                outangka = "00" + outangka;
            } else if (length_out == 3) {
                outangka = "0" + outangka;
            }
        } else if (length_angka == 2) {
            if (length_out == 5) {
                outangka = "000" + outangka;
            } else if (length_out == 6) {
                outangka = "00" + outangka;
            } else if (length_out == 7) {
                outangka = "0" + outangka;
            }
        }
        etOuput.setText(outangka);
    }

    public void fungsi (String hasil){
        String a[] = {"0", "0", "0", "0", "0", "0", "0", "0"};
        String out = "";
        int lenght_hasil = hasil.length();
        int i = 0;

        for (int k = 0; k < lenght_hasil; k++) {
            a[k] = hasil.substring(k, k + 1);
        }

        for (int c = 0; c < lenght_hasil; c++) {
            if (i == 0) {
                if (a[c].equals("0")) {
                    out = out + "δ(q0,0) = q0\n";
                    viewOut.setText(out);
                } else {
                    out = out + "δ(q0,1) = q1\n";
                    viewOut.setText(out);
                    i++;
                }
            } else if (i == 1) {
                if (a[c].equals("0")) {
                    out = out + "δ(q1,0) = q1\n";
                    viewOut.setText(out);
                } else {
                    out = out + "δ(q1,1) = q3\n";
                    viewOut.setText(out);
                    i += 2;
                }
            } else if (i == 2) {
                if (a[c].equals("0")) {
                    out = out + "δ(q2,0) = q1\n";
                    viewOut.setText(out);
                    i--;
                } else {
                    out = out + "δ(q2,1) = q3\n";
                    viewOut.setText(out);
                    i++;
                }
            } else if (i == 3) {
                if (a[c].equals("0")) {
                    out = out + "δ(q3,0) = q2\n";
                    viewOut.setText(out);
                    i--;
                } else {
                    out = out + "δ(q3,1) = q3\n";
                    viewOut.setText(out);
                }
            } else ;
        }

        if (i == 1) {
            viewOut.setText(out + "DITERIMA!");
        } else {
            viewOut.setText(out + "DITOLAK!");
        }

    }
    @Override
    public void onBackPressed() {
        Intent awal = new Intent(dfa_proses.this, dfa.class);
        startActivity(awal);
        finish();
        super.onBackPressed();
    }

}
