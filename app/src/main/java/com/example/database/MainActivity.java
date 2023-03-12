package com.example.database;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText editNama, editNIM, editJurusan;
    private Button btnTambah, btnLihatData;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all our variables.
        editNama = findViewById(R.id.editNama);
        editNIM = findViewById(R.id.editNIM);
        editJurusan  = findViewById(R.id.editJurusan);
        btnTambah = findViewById(R.id.tambah);
        btnLihatData = findViewById(R.id.btn_semua_data);

        dbHelper = new DBHelper(MainActivity.this);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mhsNama = editNama.getText().toString();
                String mhsNim = editNIM.getText().toString();
                String mhsJurusan = editJurusan.getText().toString();

                if (mhsNama.isEmpty() && mhsNim.isEmpty() && mhsJurusan.isEmpty()){
                    Toast.makeText(MainActivity.this, "Mohon diisi ulang", Toast.LENGTH_SHORT).show();
                    return;
                }

                dbHelper.tambahMahasiswa(mhsNama, mhsNim, mhsJurusan);

                Toast.makeText(MainActivity.this, "Mahasiswa berhasil ditambah!", Toast.LENGTH_SHORT).show();
                editNama.setText("");
                editNIM.setText("");
                editJurusan.setText("");
            }


        });

        btnLihatData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Viewmahasiswa.class);
                startActivity(intent);
            }
        });
    }
}