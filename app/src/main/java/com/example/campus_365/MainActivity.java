package com.example.campus_365;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import androidx.cardview.widget.CardView;

import com.example.campus_365.Admin.AdminLogin;
import com.example.campus_365.Student.StudentLogin;
import com.example.campus_365.Teacher.TeacherLogin;

public class MainActivity extends AppCompatActivity {
    CardView cbStud,cbTeacher,cbAdmin,cbInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        cbStud= (CardView)findViewById(R.id.card_stud);
        cbTeacher= (CardView)findViewById(R.id.card_teach);
        cbAdmin= (CardView)findViewById(R.id.card_admin);
        cbInfo= (CardView)findViewById(R.id.card_info);

        cbAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getApplicationContext(),AdminLogin.class);
                startActivity(i1);
            }
        });

        cbStud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getApplicationContext(),StudentLogin.class);
                startActivity(i1);
            }
        });

        cbTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getApplicationContext(),TeacherLogin.class);
                startActivity(i1);
            }
        });


    }
}
