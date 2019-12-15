package com.example.campus_365.Student;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.campus_365.MainActivity;
import com.example.campus_365.R;
import com.example.campus_365.Teacher.Attendance;
import com.example.campus_365.bean.StudentBean;

public class StudentDashboard extends AppCompatActivity {
    Button b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);

        b1=(Button)findViewById(R.id.stu_atten);
        b2=(Button)findViewById(R.id.stu_note);
        b3=(Button)findViewById(R.id.stu_btn_logout);
        b4=(Button)findViewById(R.id.tt);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StudentDashboard.this, Attendance.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=11Sw7zunVB0uOXq_8WDlVRz8Clb4qYwGH"));
                startActivity(i);


            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StudentDashboard.this, MainActivity.class);
                startActivity(i);
                StudentDashboard.this.finish();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=1KmYw3_k5BoEU53mGuI_Tv9AEHB0-7Zaw"));
                startActivity(i);
            }
        });
    }
}
