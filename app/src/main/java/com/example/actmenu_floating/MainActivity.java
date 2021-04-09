package com.example.actmenu_floating;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deklarasi variabel untuk button
    Button btnLogin;

    //Deklarasi variabel untuk EditText;
    EditText edemail, edpassword;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Method untuk menampilkan menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Membuat kondisi jika yang dipilih adalah id mnDaftar
        if (item.getItemId() == R.id.mnDaftar){
            //method untuk memanggil activity "ActMenu"
            Intent i = new Intent(getApplicationContext(), ActMenu.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnLogin dengan componen button pada layout
        btnLogin=findViewById(R.id.btSignIn);

        //Menghubungkan variabel edemail dengan componen button pada layout
        edemail=findViewById(R.id.edEmail);

        //Menghubungkan variabel edpassword dengan componen button pada layout
        edpassword=findViewById(R.id.edPassword);

        //mengeset email yang benar
        String email = "joy@email.com";

        //mengeset password yang benar
        String pass = "123";

        //mengecek apakah edittext email dan password terdapat isi atau tidak
        if (nama.isEmpty() || password.isEmpty()){
            //membuat variabel toast dan menampilkan pesan 'edittext tidak boleh kosong'
            Toast t = Toast.makeText(getApplicationContext(),
                    "Email dan Password wajib diisi!!",
                    Toast.LENGTH_LONG);
            //menampilkan toast
            t.show();
        } else {
            //mengecek apakah isi dari email dan password sudah sama dengan email dan password yg sudah diset
            if (nama.equals(email) && password.equals(pass)){
                //membuat variabel toast dan menampilkan pesan'login sukses'
                Toast t = Toast.makeText(getApplicationContext(),
                        "Login sukses",
                        Toast.LENGTH_LONG);
                //menampilkan toast
                t.show();

                //membuat objek bundle
                Bundle b = new Bundle();

                //memasukkan value dari variabel nama dengan kunci 'a'
                //dan dimasukkan kedalam bundle
                b.putString("a", nama.trim());

                //memasukkan value dari variabel password dengan kunci 'b'
                //dan dimasukkan kedalam bundle
                b.putString("b", password.trim());

                //membuat objek intent berpindah activity dari mainact ke acthasil
                Intent i = new Intent(getApplicationContext(), ActivityHasil.class);

                //memasukkan bundle kedalam intent untuk dikirimkan ke acthasil
                i.putExtras(b);

                //berpindah ke acthasil
                startActivity(i);
            } else{
                //membuat variabel toast dan membuat toast dan menampilkan pesan 'login gagal'
                Toast t = Toast.makeText(getApplicationContext(),
                        "Login gagal",
                        Toast.LENGTH_LONG);
                //menampilkan toast
                t.show();
            }
        }

        //Membuat fungsi onclick pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //menyimpan input user di edittext email ke dalam variabel nama
                nama = edemail.getText().toString();

                //menyimpan input user di edittext password ke dalam variabel password
                password = edpassword.getText().toString();
            }
        });
    }
}