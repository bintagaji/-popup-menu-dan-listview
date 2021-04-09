package com.example.actmenu_floating;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ActMenu extends AppCompatActivity {
    //deklarasi variabel dengan tipe data EditText
    EditText edtNama, edtAlamat, edtEmail, edtPassword, edtrepass;

    //Deklarasi variabel dengan tipe data floating action button
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_menu);

        fab.findViewById(R.id.fabSimpan);
        edtNama.findViewById(R.id.edNama);
        edtAlamat.findViewById(R.id.edAlamat);
        edtEmail.findViewById(R.id.edEmail);
        edtPassword.findViewById(R.id.edPass);
        edtrepass.findViewById(R.id.edrepass);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //membuat kondisi untuk mengecek apakah edittext kosong atau tidak
                if (edtNama.getText().toString().isEmpty() ||
                        edtAlamat.getText().toString().isEmpty() ||
                        edtEmail.getText().toString().isEmpty() ||
                        edtPassword.getText().toString().isEmpty() ||
                        edtrepass.getText().toString().isEmpty())
                {
                    //menampilkan pesan notifikasi jika seluruh edittext wajib diisi
                    Snackbar.make(view, "Wajib isi seluruh data!!", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    //Membuat kondisi untuk mengecek  apakah isi dari Edittext password dan edittext repassword
                    //sama atau tidak
                    if (edtPassword.getText().toString().equals(edtrepass.getText().toString()))
                    {
                        //menampilkan pesan notifikasi jika pendaftaran berhasil
                        Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil",
                                Toast.LENGTH_LONG).show();

                        //Method untuk kembali ke activity main
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        //menampilkan pesan bahwa isi dari edittext password dan edittext repassword
                        //tidak sama
                        Snackbar.make(view, "Password dan Repassword harus sama!!",
                                Snackbar.LENGTH_LONG).show();

                    }
                }
            }
        });
    }
}