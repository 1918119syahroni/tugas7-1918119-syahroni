package com.example.tugas7_1918119;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Design> ListLogo = new
            ArrayList<Design>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListLogo
        );
        mListView = (ListView) findViewById(R.id.list_logo);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListLogo.clear();
        List<Design> design = db.ReadMahasiswa();
        for (Design mhs : design) {
            Design daftar = new Design();
            daftar.set_id(mhs.get_id());
            daftar.set_logo(mhs.get_logo());
            daftar.set_tagline(mhs.get_tagline());
            ListLogo.add(daftar);
            if ((ListLogo.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int
            i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Design detailMhs = (Design)o;
        String Sid = detailMhs.get_id();
        String Slogo = detailMhs.get_logo();
        String Stagline = detailMhs.get_tagline();
        Intent goUpdel = new Intent(MainRead.this,
                MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Ilogo", Slogo);
        goUpdel.putExtra("Itagline", Stagline);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListLogo.clear();
        mListView.setAdapter(adapter_off);
        List<Design> design = db.ReadMahasiswa();
        for (Design mhs : design) {
            Design daftar = new Design();
            daftar.set_id(mhs.get_id());
            daftar.set_logo(mhs.get_logo());
            daftar.set_tagline(mhs.get_tagline());
            ListLogo.add(daftar);
            if ((ListLogo.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}

