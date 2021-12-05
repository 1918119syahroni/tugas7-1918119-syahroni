package com.example.tugas7_1918119;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_kampus";
    private static final String tb_mahasiswa = "tb_mahasiswa";
    private static final String tb_mahasiswa_id = "id";
    private static final String tb_mahasiswa_logo = "logo";
    private static final String tb_mahasiswa_tagline = "tagline";
    private static final String CREATE_TABLE_MAHASISWA = "CREATE TABLE "
            + tb_mahasiswa +"("
            + tb_mahasiswa_id + " INTEGER PRIMARY KEY ,"
            + tb_mahasiswa_logo + " TEXT ,"
            + tb_mahasiswa_tagline + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MAHASISWA);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateMahasiswa(Design data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_mahasiswa_id, data.get_id());
        values.put(tb_mahasiswa_logo, data.get_logo());
        values.put(tb_mahasiswa_tagline, data.get_tagline());
        db.insert(tb_mahasiswa, null, values);
        db.close();
    }
    public List<Design> ReadMahasiswa() {
        List<Design> listMhs = new ArrayList<Design>();
        String selectQuery = "SELECT * FROM " + tb_mahasiswa;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Design data = new Design();
                data.set_id(cursor.getString(0));
                data.set_logo(cursor.getString(1));
                data.set_tagline(cursor.getString(2));
                listMhs.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listMhs;
    }
    public int UpdateMahasiswa (Design data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_mahasiswa_logo, data.get_logo());
        values.put(tb_mahasiswa_tagline, data.get_tagline());
        return db.update(tb_mahasiswa, values, tb_mahasiswa_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteMahasiswa(Design data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_mahasiswa,tb_mahasiswa_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}