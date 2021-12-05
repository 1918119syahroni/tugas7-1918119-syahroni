package com.example.tugas7_1918119;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Slogo, Stagline;
    private EditText Elogo, Etagline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Slogo = i.getStringExtra("Ilogo");
        Stagline = i.getStringExtra("Itagline");
        Elogo = (EditText) findViewById(R.id.updel_logo);
        Etagline = (EditText) findViewById(R.id.updel_tagline);
        Elogo.setText(Slogo);
        Etagline.setText(Stagline);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Slogo = String.valueOf(Elogo.getText());
                Stagline = String.valueOf(Etagline.getText());
                if (Slogo.equals("")){
                    Elogo.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Stagline.equals("")){
                    Etagline.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi tagline",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateMahasiswa(new Design(Sid, Slogo,
                            Stagline));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteMahasiswa(new Design(Sid, Slogo,
                        Stagline));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
