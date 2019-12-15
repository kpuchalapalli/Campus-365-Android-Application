package com.example.campus_365.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import androidx.cardview.widget.CardView;

import com.example.campus_365.MainActivity;
import com.example.campus_365.R;
import com.example.campus_365.Student.StudentLogin;

public class AdminDashboard extends AppCompatActivity {
    CardView cbLogout,cbStu,cbTea,cbReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);


        cbLogout=(CardView)findViewById(R.id.card_dashLogout);
        cbStu=(CardView)findViewById(R.id.card_dashStud);
        cbTea=(CardView)findViewById(R.id.card_dashTeach);
        cbReport=(CardView)findViewById(R.id.card_dashReport);

        cbStu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AdminDashStudent.class);
                startActivity(i);

            }
        });

        cbTea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AdminDashTeacher.class);
                startActivity(i);
            }
        });

        cbReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AdminDashReport.class);
                startActivity(i);
            }
        });

        cbLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                AdminDashboard.this.finish();
            }
        });

    }
}
