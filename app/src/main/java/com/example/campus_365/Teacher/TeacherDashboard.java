package com.example.campus_365.Teacher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.campus_365.MainActivity;
import com.example.campus_365.R;

public class TeacherDashboard extends AppCompatActivity {
    Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dashboard);

        b1=(Button)findViewById(R.id.tea_viewStud);
        b2=(Button)findViewById(R.id.tea_btn_markAtten);
        b3=(Button)findViewById(R.id.log);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(TeacherDashboard.this, DisplayStudents.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(TeacherDashboard.this, Attendance.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(TeacherDashboard.this,MainActivity.class);
                startActivity(i);
                TeacherDashboard.this.finish();
            }
        });
    }
}
