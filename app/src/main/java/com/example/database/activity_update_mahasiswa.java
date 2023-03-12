package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_update_mahasiswa extends AppCompatActivity {

    private Button deleteMahasiswa;
    private DBHelper dbHelper = new DBHelper(activity_update_mahasiswa.this);
    private EditText namaEdit, nimEdit, jurusanEdit;
    String namaMahasiswa, nimMahasiswa, jurusanMahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_mahasiswa);

        namaEdit = findViewById(R.id.editNama);
        nimEdit = findViewById(R.id.editNIM);
        jurusanEdit = findViewById(R.id.editJurusan);
        deleteMahasiswa = findViewById(R.id.delete);

        namaMahasiswa = getIntent().getStringExtra("nama");
        nimMahasiswa = getIntent().getStringExtra("nim");
        jurusanMahasiswa = getIntent().getStringExtra("jurusan");

        namaEdit.setText(namaMahasiswa);
        nimEdit.setText(nimMahasiswa);
        jurusanEdit.setText(jurusanMahasiswa);

        deleteMahasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.deleteMahasiswa(namaMahasiswa);
                Toast.makeText(activity_update_mahasiswa.this, "Mahasiswa telah terhapus", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(activity_update_mahasiswa.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}