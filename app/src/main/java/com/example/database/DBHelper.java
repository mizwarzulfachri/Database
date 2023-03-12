package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "prak4";
    private static final int DB_Version = 1;
    private static final String Nama_tabel = "mahasiswa";

    private static final String id_kol = "id";
    private static final String nama_kol = "nama";
    private static final String nim_kol = "nim";
    private static final String jurusan_kol = "jurusan";

    public DBHelper(Context context){
        super(context, DB_NAME, null, DB_Version);
    }

    public void onCreate(SQLiteDatabase db){
        String query = "CREATE TABLE " + Nama_tabel+ "("
                + id_kol+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
                +nama_kol+ " TEXT,"
                +nim_kol+ " TEXT,"
                +jurusan_kol+ " TEXT)";

        db.execSQL(query);
    }

    public void tambahMahasiswa(String nama, String nim, String jurusan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(nama_kol, nama);
        values.put(nim_kol, nim);
        values.put(jurusan_kol, jurusan);

        db.insert(Nama_tabel, null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int lama, int baru) {
        db.execSQL("DROP TABLE IF EXISTS " +Nama_tabel);
        onCreate(db);
    }

    public ArrayList<MahasiswaModal> bacaSemuadata(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorMahasiswa = db.rawQuery("SELECT * FROM "+ Nama_tabel, null);

        ArrayList<MahasiswaModal> mahasiswaModalArrayList = new ArrayList<>();

        if(cursorMahasiswa.moveToFirst()){
            do {
                mahasiswaModalArrayList.add(new MahasiswaModal(
                        cursorMahasiswa.getString(1),
                        cursorMahasiswa.getString(2),
                        cursorMahasiswa.getString(3)
                ));
            }while (cursorMahasiswa.moveToNext());
        }

        cursorMahasiswa.close();
        return  mahasiswaModalArrayList;
    }

    public void deleteMahasiswa(String namaMahasiswa) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(Nama_tabel, "nama=?", new String[]{namaMahasiswa});
        db.close();
    }

}
