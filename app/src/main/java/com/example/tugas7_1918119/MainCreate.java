package com.example.tugas7_1918119;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Elogo, Etagline;
    private String Slogo, Stagline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Elogo = (EditText) findViewById(R.id.create_logo);
        Etagline = (EditText) findViewById(R.id.create_tagline);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Slogo = String.valueOf(Elogo.getText());
                Stagline = String.valueOf(Etagline.getText());
                if (Slogo.equals("")){
                    Elogo.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Stagline.equals("")) {
                    Etagline.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi tagline",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Elogo.setText("");
                    Etagline.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateMahasiswa(new Design(null, Slogo,
                            Stagline));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
