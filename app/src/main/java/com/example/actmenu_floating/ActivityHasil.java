package com.example.actmenu_floating;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityHasil extends AppCompatActivity {
    //mendeklarasikan variabel dengan tipe data TextView
    TextView txemail, txPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil2);
        //menghubungkan variabel txemail dengan component textview pd layout
        txemail = findViewById(R.id.tvEmail);

        //menghubungkan variabel txPass dengan component textview pd layout
        txPass = findViewById(R.id.tvPassword);

        //membuat objek bundle dan mengambil data yang dikirimkan dari activity sebelumnya
        Bundle bundle = getIntent().getExtras();

        //membuat variabel string yang digunakan untuk menyimpan data yang dikirimkan dari
        //activity sebelumnya dengan kunci 'a'
        String email = bundle.getString("a");

        //membuat variabel string yang digunakan untuk menyimpan data yang dikirimkan dari
        //activity sebelumnya dengan kunci 'b'
        String pass = bundle.getString("b");

        //menampilkan value dari variabel email kedalam txemail
        txemail.setText(email);

        //menampilkan value dari variabel email kedalam txPass
        txPass.setText(pass);
    }
}