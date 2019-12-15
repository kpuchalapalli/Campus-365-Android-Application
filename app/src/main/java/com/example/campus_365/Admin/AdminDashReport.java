package com.example.campus_365.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.campus_365.R;
import com.example.campus_365.Teacher.DisplayStudents;
import com.example.campus_365.Teacher.ViewStudentByBranchYear;

public class AdminDashReport extends AppCompatActivity {
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dash_report);

        b1=(Button)findViewById(R.id.view_stud);
        b2=(Button)findViewById(R.id.view_tea);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(AdminDashReport.this, DisplayStudents.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(AdminDashReport.this, ViewFacultyActivity.class);
                startActivity(i);
            }
        });
    }
}
