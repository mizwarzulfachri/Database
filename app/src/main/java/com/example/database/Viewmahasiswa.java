package com.example.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Viewmahasiswa extends AppCompatActivity {

    private ArrayList<MahasiswaModal> mahasiswaModalArrayList;
    private DBHelper dbHelper;
    private MahasiswaRVAdapter mahasiswaRVAdapter;
    private RecyclerView mahasiswaRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmahasiswa);

        mahasiswaModalArrayList = new ArrayList<>();
        dbHelper = new DBHelper(Viewmahasiswa.this);

        mahasiswaModalArrayList = dbHelper.bacaSemuadata();

        mahasiswaRVAdapter = new MahasiswaRVAdapter(mahasiswaModalArrayList, Viewmahasiswa.this);
        mahasiswaRV = findViewById(R.id.idRVMahasiswa);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Viewmahasiswa.this, RecyclerView.VERTICAL, false);
        mahasiswaRV.setLayoutManager(linearLayoutManager);

        mahasiswaRV.setAdapter(mahasiswaRVAdapter);
    }

    public void clickHandler(View view) {
        Intent intent = new Intent(Viewmahasiswa.this, MainActivity.class);
        startActivity(intent);
    }
}