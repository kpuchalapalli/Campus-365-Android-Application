package com.example.campus_365.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.campus_365.R;

public class AdminDashStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dash_student);

        Button myButton=(Button) findViewById(R.id.add_stud);// Home -> Student Login Page
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashStudent.this, AdminStudentRegistration.class);
                startActivity(intent);
            }
        });
    }
}
