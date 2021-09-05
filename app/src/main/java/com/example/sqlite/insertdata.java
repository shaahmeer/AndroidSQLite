package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class insertdata extends AppCompatActivity {

    EditText ed1,ed2,ed3;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertdata);
        ed1=findViewById(R.id.name);
        ed2=findViewById(R.id.email);
        ed3=findViewById(R.id.course);
        t1=findViewById(R.id.text1);
    }


    public void addrecord(View view){
        DBmanaget dBmanaget = new DBmanaget(this);
        String res =dBmanaget.addrecord(ed1.getText().toString(),ed2.getText().toString(),ed3.getText().toString());
        Toast.makeText(this, res, Toast.LENGTH_SHORT).show();


        ed2.setText("");
        ed3.setText("");
        t1.setText(ed1.getText().toString());
    }
}